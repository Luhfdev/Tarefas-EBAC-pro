import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class FilaFifo {

    private int[] elementos;
    private int tamanho;
    private int capacidade;

    public FilaFifo(int capacidade) {
        this.elementos = new int[capacidade];
        this.tamanho = 0;
        this.capacidade = capacidade;
    }

    public void enqueue(int elemento) {
        if (tamanho == capacidade) {
            System.out.println("A fila esta cheia!");
        } else {
            elementos[tamanho] = elemento;
            System.out.println("Numero adicionado com sucesso!: " + elemento);
            tamanho++;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("A fila esta vazia!");
            return -1;
        } else {
            int elementoRemovido = elementos[0];
            for(int i = 1; i < tamanho; i++) {
                elementos[i - 1] = elementos[i];
            }
            tamanho--;
            System.out.println("Elemento removido: " + elementoRemovido);
            return elementoRemovido;
        }
    }

    public int rear(){
        if (isEmpty()) {
            System.out.println("A fila esta vazia!");
            return -1;
        } else {
            return elementos[tamanho - 1];
        }
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("A fila esta vazia!");
            return -1;
        } else {
            return elementos[0];
        }
    }

    public int size() {
        return tamanho;
    }

    private boolean isEmpty() {
        return tamanho == 0;
    }

    public static void main(String[] args) {
        FilaFifo minhaFila = new FilaFifo(3);

        minhaFila.enqueue(10);
        minhaFila.enqueue(20);
        minhaFila.enqueue(30);
        minhaFila.enqueue(40);

        System.out.println("\nFrente da fila: " + minhaFila.front());
        System.out.println("Último da fila: " + minhaFila.rear());
        System.out.println("Tamanho da fila: " + minhaFila.size());

        minhaFila.dequeue();
        minhaFila.dequeue();

        System.out.println("\nTamanho da fila agora: " + minhaFila.size());
        System.out.println("A fila está vazia? " + minhaFila.isEmpty());

        minhaFila.dequeue();
        minhaFila.dequeue();
    }
}
