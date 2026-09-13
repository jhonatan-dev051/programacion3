import java.util.Random;

public class Ejercicio20 {
    public static void main(String[] args) {
        int[][] matriz = new int[10][10];
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j >= i) {

                    matriz[i][j] = 0;
                } else {

                    matriz[i][j] = rand.nextInt(9) + 1;
                }
            }
        }

        System.out.println("Matriz 10x10 con ceros en la diagonal principal hacia arriba:\n");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
