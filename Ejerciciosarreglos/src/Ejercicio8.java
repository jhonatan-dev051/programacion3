import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[30];

        System.out.println("Ingrese los 30 números:");
        for (int i = 0; i < 30; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        int mayor = numeros[0];
        int menor = numeros[0];

        for (int i = 1; i < 30; i++) {
            if (numeros[i] > mayor) mayor = numeros[i];
            if (numeros[i] < menor) menor = numeros[i];
        }

        int vecesMayor = 0, vecesMenor = 0;
        for (int i = 0; i < 30; i++) {
            if (numeros[i] == mayor) vecesMayor++;
            if (numeros[i] == menor) vecesMenor++;
        }

        System.out.println("Número mayor: " + mayor + " (se repite " + vecesMayor + " veces)");
        System.out.println("Número menor: " + menor + " (se repite " + vecesMenor + " veces)");

        sc.close();
    }
}
