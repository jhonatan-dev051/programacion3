import java.util.Stack;

public class pilas {
    public static void main(String[] args) throws Exception {

        Stack<String> pila = new Stack<>();

        pila.push("Libro A");
        pila.push("Libro B");
        pila.push("Libro C");

        System.out.println("Cima: " + pila.peek());

        System.out.println("Eliminado: " + pila.pop());

        System.out.println("Nueva cima: " + pila.peek());
    }
}
