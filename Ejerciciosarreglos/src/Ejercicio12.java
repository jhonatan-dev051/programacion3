import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos del arreglo A: ");
        int n = sc.nextInt();
        int[] A = new int[n];

        System.out.println("Ingrese los " + n + " elementos:");
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "]: ");
            A[i] = sc.nextInt();
        }

        System.out.print("Ingrese el valor X a buscar: ");
        int x = sc.nextInt();

        int contador = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == x)
                contador++;
        }

        int[] B = new int[contador];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == x) {

                B[j++] = i + 1;
            }
        }

        System.out.print("Arreglo B (posiciones donde A = " + x + "): [");
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i]);
            if (i < B.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        sc.close();
    }
}
