import java.util.LinkedList;
import java.util.Deque;

public class Ejercicio7 {
    public static void main(String[] args) {

        Deque<Character> bicola = new LinkedList<>();

        bicola.offerLast('A');
        bicola.offerLast('C');
        bicola.offerLast('E');

        System.out.println("--- Estado Inicial ---");
        System.out.println("Bicola: " + bicola);
        System.out.println();

        bicola.offerLast('F');
        bicola.offerLast('K');
        System.out.println("1. Añadir F y K por el final:");
        System.out.println("Bicola: " + bicola);
        System.out.println();

        bicola.offerFirst('R');
        bicola.offerFirst('W');
        bicola.offerFirst('V');
        System.out.println("2. Añadir R, W y V por el frente:");
        System.out.println("Bicola: " + bicola);
        System.out.println();

        bicola.offerLast('M');
        System.out.println("3. Añadir M por el final:");
        System.out.println("Bicola: " + bicola);
        System.out.println();

        bicola.pollFirst();
        bicola.pollFirst();
        System.out.println("4. Eliminar dos caracteres por el frente:");
        System.out.println("Bicola: " + bicola);
        System.out.println();

        bicola.offerLast('K');
        bicola.offerLast('L');
        System.out.println("5. Añadir K y L por el final:");
        System.out.println("Bicola: " + bicola);
        System.out.println();

        bicola.offerFirst('S');
        System.out.println("6. Añadir S por el frente:");
        System.out.println("Bicola: " + bicola);
    }
}