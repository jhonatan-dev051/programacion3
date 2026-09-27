import java.util.Scanner;

public class Pelicula {

    private String nombre;
    private String idioma;
    private String tipo;
    private int duracion;

    public Pelicula() {
        this.nombre = "";
        this.idioma = "";
        this.tipo = "";
        this.duracion = 0;
    }

    public Pelicula(String nombre, String idioma, String tipo, int duracion) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public Pelicula llenarDatos(Scanner teclado) {
        System.out.println("--- Agregar Pelicula ---");

        System.out.print("Ingrese el nombre: ");
        this.nombre = teclado.nextLine();

        System.out.print("Ingrese el idioma: ");
        this.idioma = teclado.nextLine();

        do {
            System.out.println("1. 35mm");
            System.out.println("2. 3D");
            System.out.print("Ingrese el tipo: ");
            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    this.tipo = "35mm";
                    break;
                case 2:
                    this.tipo = "3D";
                    break;
                default:
                    System.out.println("Tipo de pelicula invalida, ingrese una opcion valida");
            }
        } while (this.tipo.isBlank());

        System.out.print("Ingrese duracion (en minutos): ");
        this.duracion = teclado.nextInt();
        teclado.nextLine();

        return this;
    }
}