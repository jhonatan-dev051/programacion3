import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos del arreglo A: ");
        int n = sc.nextInt();
        double[] A = new double[n];

        System.out.println("Ingrese los " + n + " elementos:");
        double suma = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "]: ");
            A[i] = sc.nextDouble();
            suma += A[i];
        }

        double media = suma / n;
        System.out.println("Media (promedio): " + media);

        int contMayores = 0, contMenores = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] > media)
                contMayores++;
            else if (A[i] < media)
                contMenores++;
        }

        double[] mayores = new double[contMayores];
        double[] menores = new double[contMenores];
        int im = 0, ie = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] > media)
                mayores[im++] = A[i];
            else if (A[i] < media)
                menores[ie++] = A[i];
        }

        System.out.print("Elementos mayores que la media: ");
        imprimir(mayores);
        System.out.print("Elementos menores que la media: ");
        imprimir(menores);

        sc.close();
    }

    static void imprimir(double[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
