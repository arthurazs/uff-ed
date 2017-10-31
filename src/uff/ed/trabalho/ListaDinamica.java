package uff.ed.trabalho;

/**
 *
 * @author allyssoncc
 */
public class ListaDinamica {

    private No primeiro = null;
    private No ultimo = null;

    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public int tamanho() {
        No aux = primeiro;
        int total = 0;

        while (aux != null) {
            total++;
            aux = aux.getProximo();
        }
        return total;
    }

    public boolean estaVazia() {
        return (tamanho() == 0);
    }

    public void adicionarNoFinal(Trafego elemento) {
        if (estaVazia()) {
            adicionarNoInicio(elemento);
        } else {
            No novo = new No(elemento);
            ultimo.setProximo(novo);
            ultimo = novo;
        }
    }

    public void adicionarNoInicio(Trafego elemento) {
        No novo = new No(primeiro, elemento);
        primeiro = novo;

        if (tamanho() == 1) {
            ultimo = primeiro;
        }
    }

    public void adicionarNaPosicao(int pos, Trafego obj) {
        if (pos >= tamanho()) {
            adicionarNoInicio(obj);
        } else if (pos == 0) {
            No novo = new No(obj);
            novo.setProximo(primeiro);
            primeiro = novo;
        } else {
            int i = 1;
            No aux = primeiro;
            while (i < pos) {
                aux = aux.getProximo();
                i++;
            }
            No novo = new No(obj);
            novo.setProximo(aux.getProximo());
            aux.setProximo(novo);
        }
    }

    public void removerDoInicio() {
        if (estaVazia()) {
            System.out.println("Error: Lista vazia!");
        } else if (tamanho() > 1) {
            primeiro = primeiro.getProximo();
        } else {
            primeiro = ultimo = null;
        }
    }

    public void removerDoFinal() {
        No aux = primeiro;

        if (estaVazia()) {
            System.out.println("Error: Lista vazia!");
        } else if (tamanho() == 1) {
            removerDoInicio();
        } else {
            while (aux.getProximo().getProximo() != null) {
                aux = aux.getProximo();
            }
        }
        aux.setProximo(null);
        ultimo = aux;
    }

    public void removerDaPosicao(int pos) {
        No aux = null;
        if (pos >= 0 && pos < tamanho()) {
            if (pos == 0) {
                aux = primeiro;
                primeiro = primeiro.getProximo();
                if (primeiro == null) {
                    ultimo = null;
                }
            } else {
                int i = 1;
                No x = primeiro;
                while (i < pos) {
                    x = x.getProximo();
                    i++;
                }
                aux = x.getProximo();
                x.setProximo(aux.getProximo());
                if (aux == ultimo) {
                    ultimo = x;
                }
            }
            aux.setProximo(null);
        }
    }

    public boolean pesquisar(Trafego elemento) {
        No aux = primeiro;
        for (int i = 1; i <= tamanho(); i++) {
            if (aux.getElemento() == elemento) {
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }

    public Trafego buscar(int pos) {
        if (pos >= 0 && pos < tamanho()) {
            int i = 0;
            No aux = primeiro;
            while (i < pos) {
                i++;
                aux = aux.getProximo();
            }
            return aux.getElemento();
        }
        return null;
    }

    public void imprimirLista() {
        if (estaVazia()) {
            System.out.println("Lista vazia!");
        }
        No aux = primeiro;
        for (int i = 1; i <= tamanho(); i++) {
            System.out.print("[" + aux.getElemento().getSetor() + ", ");
            System.out.print(aux.getElemento().getRodovia() + ", ");
            System.out.print(aux.getElemento().getDia() + ", ");
            System.out.print(aux.getElemento().getFluxo() + "]");
            System.out.println("");
            aux = aux.getProximo();
        }
    }

}
