import java.util.Scanner;
import java.util.Stack;

public class Ejercicio3 {
    public static void main(String[] args) {
        int n = 5;

        @SuppressWarnings("unchecked")
        Stack<Integer>[] pilas = new Stack[n + 1];

        for (int k = 1; k <= n; k++) {
            pilas[k] = new Stack<>();
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese i (pila/operación) y j (valor): (ingrese 0 para terminar)");
            int i = scanner.nextInt();

            if (i == 0) {
                break;
            }

            int j = scanner.nextInt();
            int numPila = Math.abs(i);

            if (numPila < 1 || numPila > n) {
                System.out.println("Número de pila fuera de rango (1 a 5).");
                continue;
            }

            if (i > 0) {

                pilas[numPila].push(j);
                System.out.println("Insertado " + j + " en Pila " + numPila);
            } else {

                if (!pilas[numPila].isEmpty()) {
                    int eliminado = pilas[numPila].pop();
                    System.out.println("Eliminado " + eliminado + " de Pila " + numPila);
                } else {
                    System.out.println("La Pila " + numPila + " está vacía.");
                }
            }
        }

        System.out.println("\n--- Contenido final de las pilas ---");
        for (int k = 1; k <= n; k++) {
            System.out.println("Pila P" + k + ": " + pilas[k]);
        }

        scanner.close();
    }
}