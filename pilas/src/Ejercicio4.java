import java.util.Scanner;
import java.util.Stack;

public class Ejercicio4 {
    public static void main(String[] args) {
        int n = 5;

        @SuppressWarnings("unchecked")
        Stack<Integer>[] pilas = new Stack[n + 1];

        for (int m = 1; m <= n; m++) {
            pilas[m] = new Stack<>();
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Ingrese el triplo (i j k) para finalizar ingrese 0 en i: ");
            int i = scanner.nextInt();

            if (i == 0) {
                break;
            }

            int j = scanner.nextInt();
            int k = scanner.nextInt();

            int numPila = Math.abs(i);

            if (numPila < 1 || numPila > n) {
                System.out.println("Número de pila fuera de rango (1 a 5).");
                continue;
            }

            if (k == -1) {

                pilas[numPila].clear();
                System.out.println("Se vació completamente la Pila " + numPila);
            } else if (k == 0) {

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
            } else {
                System.out.println("Valor de k no válido. Debe ser 0 o -1.");
            }
        }

        System.out.println("\n--- Contenido final de las pilas ---");
        for (int m = 1; m <= n; m++) {
            System.out.println("Pila P" + m + ": " + pilas[m]);
        }

        scanner.close();
    }
}