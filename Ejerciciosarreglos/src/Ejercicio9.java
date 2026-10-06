import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos del arreglo: ");
        int n = sc.nextInt();
        int[] arreglo = new int[n];

        System.out.println("Ingrese los " + n + " elementos:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + i + ": ");
            arreglo[i] = sc.nextInt();
        }

        System.out.print("Ingrese el número a buscar: ");
        int buscado = sc.nextInt();

        int contador = 0;
        for (int i = 0; i < n; i++) {
            if (arreglo[i] == buscado) contador++;
        }

        System.out.println("El número " + buscado + " aparece " + contador + " veces en el arreglo.");

        sc.close();
    }
}
