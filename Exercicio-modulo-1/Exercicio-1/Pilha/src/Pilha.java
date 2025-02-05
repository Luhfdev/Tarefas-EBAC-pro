public class Pilha {

    private int[] elementos;
    private int capacidade;
    private int topo;

    public Pilha(int capacidade){
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.topo = -1;
    }

    public void push(int elemento) {
        if(topo == capacidade -1) {
          System.out.println("A Pilha esta cheia.");
        } else {
            topo++;
            elementos[topo] = elemento;
            System.out.println("Adicionado o elemento: " + elemento);
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("A Pilha esta vazia.");
            return -1;
        } else {
            int valorRemovido = elementos[topo];
            topo--;
            System.out.println("Removido: " + valorRemovido);
            return valorRemovido;
        }
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("A Pilha esta vazia.");
            return -1;
        } else {
            return elementos[topo];
        }
    }

    private boolean isEmpty() {
        return  topo == -1;
    }

    private int size() {
        return topo + 1;
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha(3);

        pilha.push(5);
        pilha.push(2);
        pilha.push(9);
        pilha.push(20);

        System.out.println("\nTopo da pilha: " + pilha.top());
        System.out.println("Tamanho da pilha: " + pilha.size());

        pilha.pop();
        pilha.pop();

        System.out.println("\nTamanho da pilha agora: " + pilha.size());
        System.out.println("A pilha está vazia? " + pilha.isEmpty());

        pilha.pop();
        pilha.pop();
    }
}


