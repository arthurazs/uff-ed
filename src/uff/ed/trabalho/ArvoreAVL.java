/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ed.trabalho;

/**
 *
 * @author allysson
 */
import java.util.ArrayList;

public class ArvoreAVL {

    protected NoAVL raiz;

    public boolean estaVazio() {
        return raiz == null;
    }

    public void adicionar(Trafego nElemento) {
        NoAVL novo = new NoAVL(nElemento);
        adicionarAVL(this.raiz, novo);
    }

    public void adicionarAVL(NoAVL atual, NoAVL nElemento) {

        if (atual == null) {
            this.raiz = nElemento;

        } else {

            if (nElemento.getElemento().getFluxo() < atual.getElemento().getFluxo()) {

                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(nElemento);
                    nElemento.setPai(atual);
                    verificaBalanceamento(atual);

                } else {
                    adicionarAVL(atual.getEsquerda(), nElemento);
                }

            } else if (nElemento.getElemento().getFluxo() > atual.getElemento().getFluxo()) {

                if (atual.getDireita() == null) {
                    atual.setDireita(nElemento);
                    nElemento.setPai(atual);
                    verificaBalanceamento(atual);

                } else {
                    adicionarAVL(atual.getDireita(), nElemento);
                }

            } else {
                // O nó já existe
            }
        }
    }

    public void verificaBalanceamento(NoAVL atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getAltura();

        if (balanceamento == -2) {

            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
                atual = giroDireita(atual);

            } else {
                atual = duploGiroEsquerdaDireita(atual);
            }

        } else if (balanceamento == 2) {

            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
                atual = giroEsquerda(atual);

            } else {
                atual = duploGiroDireitaEsquerda(atual);
            }
        }

        if (atual.getPai() != null) {
            verificaBalanceamento(atual.getPai());
        } else {
            this.raiz = atual;
        }
    }

    public void remover(double fluxo) {
        removerAVL(this.raiz, fluxo);
    }

    public void removerAVL(NoAVL atual, double fluxo) {
        if (atual == null) {
            return;

        } else {

            if (atual.getElemento().getFluxo() > fluxo) {
                removerAVL(atual.getEsquerda(), fluxo);

            } else if (atual.getElemento().getFluxo() < fluxo) {
                removerAVL(atual.getDireita(), fluxo);

            } else if (atual.getElemento().getFluxo() == fluxo) {
                removerNoEncontrado(atual);
            }
        }
    }

    public void removerNoEncontrado(NoAVL aRemover) {
        NoAVL rem;

        if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {

            if (aRemover.getPai() == null) {
                this.raiz = null;
                aRemover = null;
                return;
            }
            rem = aRemover;

        } else {
            rem = sucessor(aRemover);
            aRemover.setElemento(rem.getElemento());
        }

        NoAVL p;
        if (rem.getEsquerda() != null) {
            p = rem.getEsquerda();
        } else {
            p = rem.getDireita();
        }

        if (p != null) {
            p.setPai(rem.getPai());
        }

        if (rem.getPai() == null) {
            this.raiz = p;
        } else {
            if (rem == rem.getPai().getEsquerda()) {
                rem.getPai().setEsquerda(p);
            } else {
                rem.getPai().setDireita(p);
            }
            verificaBalanceamento(rem.getPai());
        }
        rem = null;
    }

    public NoAVL giroEsquerda(NoAVL inicial) {

        NoAVL direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {

            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);

            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    public NoAVL giroDireita(NoAVL inicial) {

        NoAVL esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);

            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    public NoAVL duploGiroEsquerdaDireita(NoAVL inicial) {
        inicial.setEsquerda(giroEsquerda(inicial.getEsquerda()));
        return giroDireita(inicial);
    }

    public NoAVL duploGiroDireitaEsquerda(NoAVL inicial) {
        inicial.setDireita(giroDireita(inicial.getDireita()));
        return giroEsquerda(inicial);
    }

    public NoAVL sucessor(NoAVL q) {
        if (q.getDireita() != null) {
            NoAVL r = q.getDireita();
            while (r.getEsquerda() != null) {
                r = r.getEsquerda();
            }
            return r;
        } else {
            NoAVL p = q.getPai();
            while (p != null && q == p.getDireita()) {
                q = p;
                p = q.getPai();
            }
            return p;
        }
    }

    private int altura(NoAVL atual) {
        if (atual == null) {
            return -1;
        }

        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 0;

        } else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());

        } else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());

        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    private void setBalanceamento(NoAVL no) {
        no.setAltura(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    public NoAVL procurarFluxo(double fluxo, NoAVL t) {
        while (t != null) {
            if (fluxo < t.getElemento().getFluxo()) {
                t = t.getEsquerda();
            } else if (fluxo > t.getElemento().getFluxo()) {
                t = t.getDireita();
            } else {
                return t;
            }
        }
        return null;
    }

    public void imprimirAVL() {
        raiz.imprimirArvore();
    }
}
