import java.util.Scanner;

public class Main {

        public static void main(String[] args) throws Exception {
                Scanner teclado = new Scanner(System.in);
                Cine cine = new Cine("Cine Colombia");
                boolean salir = false;

                while (!salir) {
                        try {
                                System.out.println("--- MENU ---");
                                System.out.println("1. Crear peliculas");
                                System.out.println("2. Asignar funciones");
                                System.out.println("3. Realizar venta");
                                System.out.println("4. Salir");
                                System.out.print("Ingrese una opcion: ");
                                int opcion = teclado.nextInt();

                                System.out.println(opcion);

                                switch (opcion) {
                                        case 1:
                                                cine.agregarPeliculas(teclado);
                                                break;
                                        case 2:
                                                cine.agregarFunciones(teclado);
                                                break;
                                        case 3:
                                                cine.realizarVenta(teclado);
                                                break;
                                        case 4:
                                                salir = true;
                                                break;
                                        default:
                                                throw new Exception(
                                                                "Opcion invalida. Por favor, ingrese un numero del 1 al 4.");
                                }
                        } catch (Exception e) {
                                System.out.println(e.getMessage());
                        }
                }

                teclado.close();
        }
}