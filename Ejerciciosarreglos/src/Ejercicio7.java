import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] A = new int[10];

        System.out.println("Ingrese los 10 elementos del arreglo A:");
        for (int i = 0; i < 10; i++) {
            System.out.print("A[" + i + "]: ");
            A[i] = sc.nextInt();
        }

        int contPares = 0, contImpares = 0;
        for (int i = 0; i < 10; i++) {
            if (A[i] % 2 == 0)
                contPares++;
            else
                contImpares++;
        }

        int[] pares = new int[contPares];
        int[] impares = new int[contImpares];
        int p = 0, im = 0;

        for (int i = 0; i < 10; i++) {
            if (A[i] % 2 == 0) {
                pares[p++] = A[i];
            } else {
                impares[im++] = A[i];
            }
        }

        System.out.print("Arreglo de pares: ");
        imprimirArreglo(pares);
        System.out.print("Arreglo de impares: ");
        imprimirArreglo(impares);

        sc.close();
    }

    static void imprimirArreglo(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
