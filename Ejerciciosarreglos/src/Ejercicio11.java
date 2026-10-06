import java.util.Scanner;

public class Ejercicio11 {
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

        int contNeg = 0, contCero = 0, contPos = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] < 0) contNeg++;
            else if (A[i] == 0) contCero++;
            else contPos++;
        }

        int[] negativos = new int[contNeg];
        int[] ceros = new int[contCero];
        int[] positivos = new int[contPos];
        int ineg = 0, icero = 0, ipos = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] < 0) negativos[ineg++] = A[i];
            else if (A[i] == 0) ceros[icero++] = A[i];
            else positivos[ipos++] = A[i];
        }

        System.out.print("Negativos: ");
        imprimir(negativos);
        System.out.print("Ceros: ");
        imprimir(ceros);
        System.out.print("Positivos: ");
        imprimir(positivos);

        sc.close();
    }

    static void imprimir(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
