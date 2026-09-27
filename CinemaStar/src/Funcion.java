import java.util.Scanner;

public class Funcion {

    private Pelicula pelicula;
    private Sala sala;
    private String horario;
    private String tipo;

    public Funcion() {
        this.pelicula = null;
        this.sala = null;
        this.horario = "";
        this.tipo = "";
    }

    public Funcion(
            Pelicula pelicula,
            Sala sala,
            String horario,
            String tipo) {

        this.pelicula = pelicula;
        this.sala = sala;
        this.horario = horario;
        this.tipo = tipo;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public String getHorario() {
        return horario;
    }

    public String getTipo() {
        return tipo;
    }

    public Funcion llenarDatos(
            Scanner teclado,
            Sala[] salas,
            Pelicula[] peliculas,
            Funcion[] funciones) {

        System.out.println("--- Agregar Funcion ---");

        do {

            for (int i = 0; i < peliculas.length; i++) {

                if (peliculas[i] != null) {
                    System.out.println(
                            (i + 1) + ". " + peliculas[i].getNombre() + " (" + peliculas[i].getTipo() + ")");
                }
            }

            System.out.print("Seleccione la pelicula para la funcion: ");

            int opcionPelicula = teclado.nextInt();
            teclado.nextLine();

            if (opcionPelicula < 1
                    || opcionPelicula > peliculas.length
                    || peliculas[opcionPelicula - 1] == null) {

                System.out.println("Opción de película inválida.");

            } else {

                this.pelicula = peliculas[opcionPelicula - 1];
            }

        } while (this.pelicula == null);

        do {

            System.out.println("1. 14:00 - 16:30");
            System.out.println("2. 16:30 - 19:00");
            System.out.println("3. 19:00 - 21:00");

            System.out.print(
                    "Seleccione el horario para la funcion (1-3): ");

            int opcionHorario = teclado.nextInt();
            teclado.nextLine();

            switch (opcionHorario) {

                case 1:
                    this.horario = "14:00 - 16:30";
                    break;

                case 2:
                    this.horario = "16:30 - 19:00";
                    break;

                case 3:
                    this.horario = "19:00 - 21:00";
                    break;

                default:
                    System.out.println(
                            "Opción de horario inválida.");
            }

        } while (this.horario.isBlank());

        do {

            System.out.println("\nSalas disponibles:");

            if (this.pelicula
                    .getTipo()
                    .equalsIgnoreCase("3D")) {

                System.out.println("3. " + salas[2].getNombre());

            } else {

                for (int i = 0; i < 3; i++) {

                    System.out.println(
                            (i + 1) + ". "
                                    + salas[i].getNombre());
                }
            }

            System.out.print(
                    "Seleccione la sala para la funcion: ");

            int opcionSala = teclado.nextInt();
            teclado.nextLine();

            if (opcionSala < 1 || opcionSala > salas.length) {

                System.out.println(
                        "Opción de sala inválida.");

            } else {

                if (this.pelicula
                        .getTipo()
                        .equalsIgnoreCase("3D")
                        && opcionSala != 3) {

                    System.out.println(
                            "Una película 3D solo puede estar "
                                    + "en la sala 3.");

                } else {

                    this.sala = salas[opcionSala - 1];
                }
            }

        } while (this.sala == null);

        boolean horarioOcupado = false;

        for (int i = 0; i < funciones.length; i++) {

            if (funciones[i] != null) {

                if (funciones[i].getSala() == this.sala
                        && funciones[i].getHorario().equals(horario)) {

                    horarioOcupado = true;
                    break;
                }
            }
        }

        if (horarioOcupado) {

            System.out.println(
                    "ERROR: La sala "
                            + this.sala.getNombre()
                            + " ya tiene una función en el horario "
                            + horario);

            return null;
        }

        this.tipo = this.pelicula.getTipo();

        return this;
    }

    public void mostrarInformacion() {

        System.out.println(
                "Película: " + pelicula.getNombre());

        System.out.println(
                "Sala: " + sala.getNombre());

        System.out.println(
                "Horario: " + horario);

        System.out.println(
                "Tipo: " + tipo);
    }
}