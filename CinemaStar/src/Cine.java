import java.util.Scanner;

public class Cine {

    private String nombre;
    private Sala[] salas;
    private Pelicula[] peliculas;
    private Funcion[] funciones;
    private Venta[] ventas;
    private int contadorVentas;

    public Cine(String nombre) {
        this.nombre = nombre;

        this.salas = new Sala[] {
                new SalaExtendida("Sala 1"),
                new SalaExtendida("Sala 2"),
                new Sala3D("Sala 3")
        };

        this.ventas = new Venta[100];
        this.contadorVentas = 0;
        this.llenarSalas();
    }

    public void agregarPeliculas(Scanner teclado) {
        System.out.print("Cuantas peliculas desea agregar: ");
        int cantidadPeliculas = teclado.nextInt();
        teclado.nextLine();

        peliculas = new Pelicula[cantidadPeliculas];

        for (int i = 0; i < cantidadPeliculas; i++) {
            Pelicula nuevaPelicula = new Pelicula();
            nuevaPelicula.llenarDatos(teclado);
            peliculas[i] = nuevaPelicula;
        }
    }

    public void agregarFunciones(Scanner teclado) {
        System.out.print("Cuantas funciones desea agregar: ");
        int cantidadFunciones = teclado.nextInt();
        teclado.nextLine();

        funciones = new Funcion[cantidadFunciones];

        for (int i = 0; i < cantidadFunciones; i++) {
            Funcion nuevaFuncion = new Funcion();
            nuevaFuncion.llenarDatos(teclado, salas, peliculas, funciones);
            funciones[i] = nuevaFuncion;
        }
    }

    public void llenarSalas() {
        for (Sala sala : salas) {
            sala.llenarSillas();
        }
    }

    public void mostrarSalas() {
        System.out.println("Cine: " + nombre);

        for (Sala sala : salas) {
            sala.mostrarSillas();
        }
    }

    public void realizarVenta(Scanner teclado) {
        if (funciones == null || funciones.length == 0) {
            System.out.println("No hay funciones disponibles para la venta.");
            return;
        }

        System.out.print("Nombre del cliente: ");
        String cliente = teclado.nextLine();

        System.out.println("\n--- Funciones disponibles ---");
        for (int i = 0; i < funciones.length; i++) {
            if (funciones[i] != null) {
                System.out.println((i + 1) + ". " + funciones[i].getPelicula().getNombre()
                        + " | Sala: " + funciones[i].getSala().getNombre());
            }
        }
        System.out.print("Seleccione la funcion: ");
        int opcionFuncion = teclado.nextInt() - 1;
        teclado.nextLine();

        if (opcionFuncion < 0 || opcionFuncion >= funciones.length || funciones[opcionFuncion] == null) {
            System.out.println("Opción de función inválida.");
            return;
        }

        Funcion funcionSeleccionada = funciones[opcionFuncion];
        Sala salaDeFuncion = funcionSeleccionada.getSala();

        salaDeFuncion.mostrarSillas();

        System.out.print("¿Cuántas sillas desea comprar? ");
        int cantidadSillas = teclado.nextInt();
        teclado.nextLine();

        if (cantidadSillas <= 0) {
            System.out.println("La cantidad de sillas debe ser mayor a cero.");
            return;
        }

        Silla[] sillasSeleccionadas = new Silla[cantidadSillas];
        for (int i = 0; i < cantidadSillas; i++) {
            System.out.print("Ingrese la etiqueta de la silla " + (i + 1) + " (ej. A3): ");
            String etiqueta = teclado.nextLine();

            Silla sillaBuscada = salaDeFuncion.buscarSillaPorEtiqueta(etiqueta);
            if (sillaBuscada == null) {
                System.out.println("La silla " + etiqueta + " no existe. Venta cancelada.");
                return;
            }
            sillasSeleccionadas[i] = sillaBuscada;
        }

        Venta nuevaVenta = new Venta(cliente, funcionSeleccionada, sillasSeleccionadas);
        boolean exito = nuevaVenta.realizarVenta();

        if (exito) {
            // Guardar la venta en el arreglo
            if (contadorVentas < ventas.length) {
                ventas[contadorVentas] = nuevaVenta;
                contadorVentas++;
            }
        }
    }

    public Sala[] getSalas() {
        return salas;
    }

    public Venta[] getVentas() {
        return ventas;
    }

}