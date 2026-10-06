import java.util.Scanner;

public class Ejercicio10 {
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

        int tamB = (n + 1) / 2;
        int[] B = new int[tamB];
        int mid = n / 2;

        for (int i = 0; i < tamB; i++) {
            if (n % 2 != 0 && i == tamB - 1) {

                B[i] = A[mid];
            } else {
                B[i] = A[i] + A[n - 1 - i];
            }
        }

        System.out.print("Arreglo B (suma de opuestos): [");
        for (int i = 0; i < tamB; i++) {
            System.out.print(B[i]);
            if (i < tamB - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        sc.close();
    }
}
