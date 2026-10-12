import java.util.LinkedList;
import java.util.Queue;

public class colas {
    public static void main(String[] args) throws Exception {
        Queue<String> cola = new LinkedList<>();

        cola.offer("Cliente 1");
        cola.offer("Cliente 2");
        cola.offer("Cliente 3");

        System.out.println("Primero en la fila: " + cola.peek());

        // Atender al primero (Poll)
        System.out.println("Atendido: " + cola.poll()); // Elimina y muestra: Cliente 1

        // Ahora el primero es Cliente 2
        System.out.println("Nuevo primero: " + cola.peek()); // Muestra: Cliente 2
    }
}
