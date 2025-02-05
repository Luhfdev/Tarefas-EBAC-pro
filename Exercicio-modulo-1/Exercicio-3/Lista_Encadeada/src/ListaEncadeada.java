class Node {
    int elemento;
    Node proximo;

    public Node(int valor) {
        this.elemento = valor;
        this.proximo = null;
    }
}

public class ListaEncadeada {
    private Node cabeca;
    private int tamanho;

    public ListaEncadeada() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public void push(Node node) {
        if (cabeca == null) {
            cabeca = node;
        } else {
            Node atual = cabeca;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = node;
        }
        tamanho++;
    }

    public Node pop() {
        if (cabeca == null) {
            System.out.println("A lista esta vazia!");
            return null;
        } else {
            if (cabeca.proximo == null) {
                Node removido = cabeca;
                cabeca = null;
                tamanho--;
                return removido;
            }

            Node atual = cabeca;
            while (atual.proximo.proximo != null) {
                atual = atual.proximo;
            }
            Node removido = atual.proximo;
            atual.proximo = null;
            tamanho--;
            System.out.println("node removido com sucesso!");
            return removido;
        }
    }

    public void insert(int index, Node node) {
        if (cabeca == null || index < 0 || index > tamanho) {
            System.out.println("A lista esta vazia ou indice invalido!");
        } else {
            Node atual = cabeca;
            for (int i = 0 ; i < index -1 ; i++) {
                atual = atual.proximo;
            }
            node.proximo = atual.proximo;
            atual.proximo = node;
            System.out.println("node inserido com sucesso!");
        }
        tamanho++;
    }

    public void remove(int index) {
        if (cabeca == null || index < 0 || index > tamanho) {
            System.out.println("A lista esta vazia ou indice invalido!");
        } else {
            Node atual = cabeca;
            for (int i = 0 ; i < index -1 ; i++) {
                atual = atual.proximo;
            }
            atual.proximo = atual.proximo.proximo;
            System.out.println("node removido com sucesso!");
        }
        tamanho--;
    }

    public Node elementAt(int index) {
        if (cabeca == null || index < 0 || index > tamanho) {
            System.out.println("A lista esta vazia ou indice invalido!");
            return null;
        } else {
            Node atual = cabeca;
            for (int i = 0; i < index; i++) {
                atual = atual.proximo;
            }
            return atual;
        }
    }

    public int size() {
        return tamanho;
    }

    public void printList() {
        if (cabeca == null) {
            System.out.println("A lista esta vazia ou indice invalido!");
        } else {
            Node atual = cabeca;
            System.out.print("Lista: ");
            while (atual != null) {
                System.out.print(atual.elemento + " -> ");
                atual = atual.proximo;
            }
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.push(new Node(10));
        lista.push(new Node(20));
        lista.push(new Node(30));
        lista.printList();

        lista.pop();
        lista.printList();

        lista.insert(1, new Node(25));
        lista.printList();

        lista.remove(1);
        lista.printList();

        System.out.println("Elemento no índice 1: " + lista.elementAt(1).elemento);

        System.out.println("Tamanho da lista: " + lista.size());
    }
}
