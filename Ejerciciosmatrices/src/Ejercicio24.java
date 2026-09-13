import java.util.Scanner;

public class Ejercicio24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cereales = { "Arroz", "Avena", "Cebada", "Trigo" };
        String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };

        int[][] produccion = new int[12][4];

        System.out.println("Ingrese la producción (en toneladas) de cada cereal por mes:");
        for (int i = 0; i < 12; i++) {
            System.out.println("--- " + meses[i] + " ---");
            for (int j = 0; j < 4; j++) {
                System.out.print(cereales[j] + ": ");
                produccion[i][j] = sc.nextInt();
            }
        }

        int[] totalMes = new int[12];
        int totalAnual = 0;
        for (int i = 0; i < 12; i++) {
            int suma = 0;
            for (int j = 0; j < 4; j++) {
                suma += produccion[i][j];
            }
            totalMes[i] = suma;
            totalAnual += suma;
        }

        double promedioAnual = totalAnual / 12.0;

        int mesesSuperiores = 0, mesesInferiores = 0;
        for (int i = 0; i < 12; i++) {
            if (totalMes[i] > promedioAnual)
                mesesSuperiores++;
            else if (totalMes[i] < promedioAnual)
                mesesInferiores++;
        }

        int mesMayorProduccion = 0;
        for (int i = 1; i < 12; i++) {
            if (totalMes[i] > totalMes[mesMayorProduccion])
                mesMayorProduccion = i;
        }

        System.out.println("\n--- Resultados ---");
        System.out.printf("a. Promedio anual de toneladas cosechadas (mensual): %.2f%n", promedioAnual);
        System.out.println("b. Meses con cosecha superior al promedio: " + mesesSuperiores);
        System.out.println("c. Meses con cosecha inferior al promedio: " + mesesInferiores);
        System.out.println("d. Mes con mayor producción: " + meses[mesMayorProduccion] + " ("
                + totalMes[mesMayorProduccion] + " toneladas)");

        sc.close();
    }
}
