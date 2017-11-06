package uff.ed.trabalho;

/**
 *
 * @author allyssoncc
 */
public class ListaDinamica {

    private No primeiro = null;
    private int tamanho = 0;

    public Trafego buscar(int chave) {
        No no = primeiro;
        while (no != null) {
            if (no.getElemento().getChave() == chave)
                return no.getElemento();
            no = no.getProximo();
        }
        return null;
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

    public void referenciar(Trafego elemento) {
        referenciarProximo(primeiro, elemento);
    }

    public void referenciarProximo(No no, Trafego elemento) {
        if (no != null)
            if (!no.getElemento().equals(elemento))
                adicionarProximo(no.getProximo(), elemento);
            else {
                primeiro = new No(primeiro, elemento);
                tamanho++;
            }
    }

    public void adicionar(Trafego elemento) {
        adicionarProximo(primeiro, elemento);
    }

    public void adicionarProximo(No no, Trafego elemento) {
        if (no != null)
            if (no.getElemento().equals(elemento)) {
                // se já existe, totaliza
                Double fluxo = no.getElemento().getFluxo() + elemento.getFluxo();
                no.getElemento().setFluxo(fluxo);
            }
            else
                adicionarProximo(no.getProximo(), elemento);
        else {
            primeiro = new No(primeiro, elemento);
            tamanho++;
        }
    }

    public Trafego[] estatica() {
        Trafego[] lista = new Trafego[tamanho];
        int cont = 0;
        No no = primeiro;
        while (no != null) {
            lista[cont++] = no.getElemento();
            no = no.getProximo();
        }
        return lista;
    }

    public void imprimirListaLn() {
        if (estaVazia())
            System.out.println("Lista vazia!");
        No aux = primeiro;
        for (int i = 1; i <= tamanho(); i++) {
            System.out.println(aux.getElemento());
            aux = aux.getProximo();
        }
    }

    public void imprimirLista() {
        if (estaVazia())
            System.out.println("Lista vazia!");
        No aux = primeiro;
        for (int i = 1; i <= tamanho(); i++) {
            System.out.print(aux.getElemento() + " ");
            aux = aux.getProximo();
        }
        System.out.println();
    }

}
