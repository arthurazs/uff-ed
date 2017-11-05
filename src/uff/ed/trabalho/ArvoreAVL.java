package uff.ed.trabalho;

/**
 *
 * @author allyssoncc
 */
public class ArvoreAVL {

    NoAVL raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    public boolean estaVazio() {
        return raiz == null;
    }

    public NoAVL adicionar(Trafego elemento, NoAVL atual) {
        if (atual == null) // se não tiver nada cria raiz
        {
            atual = new NoAVL(elemento);
        } else if (elemento.getFluxo() < atual.getElemento().getFluxo()) { // se novo menor que o existente
            atual.setEsquerda(adicionar(elemento, atual.getEsquerda())); // insere recursivamente
            if (altura(atual.getEsquerda()) - altura(atual.getDireita()) == 2) // se houver diferença igual a 2
            {
                if (elemento.getFluxo() < atual.getEsquerda().getElemento().getFluxo()) // se novo é menor que esquerda do atual
                {
                    atual = girarFilhoEsquerda(atual);  // faz giro
                } else {
                    atual = duploFilhoEsquerda(atual);  // faz giro
                }
            }
        } else if (elemento.getFluxo() > atual.getElemento().getFluxo()) { // se novo maior que o existente
            atual.setDireita(adicionar(elemento, atual.getDireita())); // insere na direita
            if (altura(atual.getDireita()) - altura(atual.getEsquerda()) == 2) // se houver diferença na altura igual a 2
            {
                if (elemento.getFluxo() > atual.getDireita().getElemento().getFluxo()) // se novo é menor que direita do atual
                {
                    atual = girarFilhoDireita(atual); // faz giro
                } else {
                    atual = duploFilhoDireita(atual); // faz giro
                }
            }
        } else
            ;  // nao faz nada
        atual.setAltura(maximo(altura(atual.getEsquerda()), altura(atual.getDireita())) + 1); //seta altura do no q foi inserido
        return atual;
    }

    public boolean estaBalanceada(NoAVL no) { // verifica se a árvore está balanceada
        NoAVL atual = no;
        while (atual != null) { // verifica nós da Direita
            if (altura(atual.getDireita()) - altura(atual.getEsquerda()) == 2) {
                atual = atual.getDireita();
                return false;
            }
            atual = atual.getDireita();
        }
        atual = no;
        while (atual != null) { // verifica nós da Direita
            if (altura(atual.getDireita()) - altura(atual.getEsquerda()) == 2) {
                atual = atual.getEsquerda();
                return false;
            }
            atual = atual.getDireita();
        }
        return true;
    }

    public void efetuaBalanceamento(NoAVL no) {    // efetua balançeamento efetuando os giros
        if (no.getElemento().getFluxo() > no.getDireita().getElemento().getFluxo()) {
            raiz = girarFilhoDireita(raiz); // giro se dado da raiz maior que dado da direita
        } else {
            raiz = duploFilhoDireita(raiz); // giro se dado da raiz menor que dado da direita
        }
    }

    public boolean remover(double fluxo, NoAVL no) { // método de remoção 
        NoAVL atual = no;
        NoAVL anterior = no;
        boolean eFilhoEsquerda = true;

        NoAVL elementoRemover = procurar(fluxo, no);
        if (elementoRemover != null) {
            System.out.println("Fluxo " + elementoRemover.getElemento().getFluxo() + " sera removido");

            while (atual.getElemento().getFluxo() != fluxo) {
                anterior = atual;
                if (fluxo < atual.getElemento().getFluxo()) { // vai pra esquerda?
                    eFilhoEsquerda = true;
                    atual = atual.getEsquerda();
                } else { // ou direita?
                    eFilhoEsquerda = false;
                    atual = atual.getDireita();
                }
                if (atual == null) {
                    return false;
                }
            }
            if ((atual.getEsquerda()) == null && (atual.getDireita() == null)) { // se ambos os lados forem nulos
                if (atual == raiz) // se for raiz árvore é vazia
                {
                    raiz = null;
                } else if (eFilhoEsquerda) // verifica se é filho esquerda ou não
                {
                    anterior.setEsquerda(null); // remove
                } else {
                    anterior.setDireita(null); // remove
                }
            } else if (atual.getDireita() == null) // se esquerda é nulo
            {
                if (atual == raiz) {
                    raiz = atual.getEsquerda();
                } else if (eFilhoEsquerda) // verifica  se é filho esquerda
                {
                    anterior.setEsquerda(atual.getEsquerda());
                } else {
                    anterior.setDireita(atual.getEsquerda());
                }
            } else if (atual.getEsquerda() == null) // se esquerda é nulo
            {
                if (atual == raiz) {
                    raiz = atual.getDireita();
                } else if (eFilhoEsquerda) // verifica se é filho esquerda
                {
                    anterior.setEsquerda(atual.getDireita());
                } else {
                    anterior.setDireita(atual.getDireita());
                }
            } else { // se nem esquerda nem direita ou ambos forem nulos, entra aqui
                NoAVL sucessor = getSucessor(atual); // pega o sucessor
                if (atual == raiz) {
                    raiz = sucessor;
                } else if (eFilhoEsquerda) {
                    anterior.setEsquerda(sucessor);
                } else {
                    anterior.setDireita(sucessor);
                }
                sucessor.setEsquerda(atual.getEsquerda());
            }
            if (estaBalanceada(raiz)) // se estiver balanceada remoção está terminada
            {
                return true;
            } else {
                efetuaBalanceamento(raiz); // se não efetua giros para balanceamento
                return true;
            }
        }
        System.out.println("Fluxo não encontrado");
        return false;
    }

    public NoAVL getSucessor(NoAVL no) {  // pega o sucessor
        NoAVL sucessorAnterior = no;
        NoAVL sucessor = no;
        NoAVL atual = no.getDireita(); // vai para filho da direita
        while (atual != null) { // enquanto houver
            sucessorAnterior = sucessor;
            sucessor = atual.getEsquerda();
        }

        if (sucessor != no.getDireita()) {
            sucessorAnterior.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(no.getDireita());
        }
        return sucessor;
    }

    public NoAVL procurar(double fluxo, NoAVL t) { // método de procura
        while (t != null) {
            if (fluxo < t.getElemento().getFluxo()) {
                t = t.getEsquerda();
            } else if (fluxo > t.getElemento().getFluxo()) {
                t = t.getDireita();
            } else {
                return t; // se achar retorna t
            }
        }
        return null; // se não achar retorna null
    }

    public static int altura(NoAVL t) { // retorna a altura
        return t == null ? -1 : t.getAltura();
    }

    public static int maximo(int lhs, int rhs) { // retorna maxima
        return lhs > rhs ? lhs : rhs;
    }

    public static NoAVL girarFilhoEsquerda(NoAVL k2) { // giro
        NoAVL k1 = k2.getEsquerda();
        k2.setEsquerda(k1.getDireita());
        k1.setDireita(k2);
        k2.setAltura(maximo(altura(k2.getEsquerda()), altura(k2.getDireita())) + 1);
        k1.setAltura(maximo(altura(k1.getEsquerda()), k2.getAltura()) + 1);
        return k1;
    }

    public static NoAVL girarFilhoDireita(NoAVL k1) { // giro
        NoAVL k2 = k1.getDireita();
        k1.setDireita(k2.getEsquerda());
        k2.setEsquerda(k1);
        k1.setAltura(maximo(altura(k1.getEsquerda()), altura(k1.getDireita())) + 1);
        k2.setAltura(maximo(altura(k2.getDireita()), k1.getAltura()) + 1);
        return k2;
    }

    public static NoAVL duploFilhoEsquerda(NoAVL k3) {
        k3.setEsquerda(girarFilhoDireita(k3.getEsquerda()));
        return girarFilhoEsquerda(k3);
    }

    public static NoAVL duploFilhoDireita(NoAVL k1) {
        k1.setDireita(girarFilhoEsquerda(k1.getDireita()));
        return girarFilhoDireita(k1);
    }

    void adicionar(Trafego elemento) { // adicionar que chama adicionar com parametro elemento e raiz
        raiz = adicionar(elemento, raiz);
    }

    public boolean procurar(double fluxo) { // procurar que chama procurar com parametro elemento e raiz
        if (procurar(fluxo, raiz) == null) {
            return false;
        }
        return true;
    }

    public void imprimirAVL() {
        raiz.imprimirArvore();
    }
}
