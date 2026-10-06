import java.util.Scanner;

public class Ejercicio21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el orden M de la matriz cuadrada (M x M): ");
        int m = sc.nextInt();

        int[][] matriz = new int[m][m];

        System.out.println("Ingrese los elementos de la matriz:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("[" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }

        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            int sumaPares = 0;
            for (int j = 0; j < m; j++) {
                if (matriz[i][j] % 2 == 0) {
                    sumaPares += matriz[i][j];
                }
            }
            B[i] = sumaPares;
        }

        System.out.print("\nVector B (suma de valores pares por fila): [");
        for (int i = 0; i < m; i++) {
            System.out.print(B[i]);
            if (i < m - 1) System.out.print(", ");
        }
        System.out.println("]");

        sc.close();
    }
}
