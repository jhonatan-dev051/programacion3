public class Venta {

    private String cliente;
    private Funcion funcion;
    private Silla[] sillas;
    private double precioTotal;

    public Venta() {
        this.sillas = new Silla[0];
    }

    public Venta(String cliente, Funcion funcion, Silla[] sillas) {
        this.cliente = cliente;
        this.funcion = funcion;

        if (sillas != null) {
            this.sillas = new Silla[sillas.length];
            for (int i = 0; i < sillas.length; i++) {
                this.sillas[i] = sillas[i];
            }
        } else {
            this.sillas = new Silla[0];
        }

        this.precioTotal = calcularPrecioTotal();
    }

    private double calcularPrecioTotal() {
        double total = 0.0;

        if (funcion == null || funcion.getSala() == null) {
            return total;
        }

        Sala salaActual = funcion.getSala();

        for (int i = 0; i < sillas.length; i++) {
            Silla s = sillas[i];
            if (s != null) {
                if (salaActual instanceof Sala3D) {
                    total += 10000;
                } else if (s.esPreferencial()) {
                    total += 12000;
                } else {
                    total += 8000;
                }
            }
        }
        return total;
    }

    public boolean realizarVenta() {
        if (sillas == null || sillas.length == 0) {
            System.out.println("No ha seleccionado ninguna silla.");
            return false;
        }

        for (int i = 0; i < sillas.length; i++) {
            if (sillas[i] != null && sillas[i].estaOcupada()) {
                System.out.println("La silla " + sillas[i].getEtiqueta() + " ya esta ocupada. Venta cancelada.");
                return false;
            }
        }

        for (int i = 0; i < sillas.length; i++) {
            if (sillas[i] != null) {
                sillas[i].ocupar();
            }
        }

        String nombrePelicula = (funcion != null && funcion.getPelicula() != null)
                ? funcion.getPelicula().getNombre()
                : "Sin definir";
        String nombreSala = (funcion != null && funcion.getSala() != null)
                ? funcion.getSala().getNombre()
                : "Sin definir";

        System.out.println("\n--- VENTA REALIZADA ---");
        System.out.println("Cliente: " + cliente);
        System.out.println("Pelicula: " + nombrePelicula);
        System.out.println("Sala: " + nombreSala);

        System.out.print("Sillas: ");
        for (int i = 0; i < sillas.length; i++) {
            if (sillas[i] != null) {
                System.out.print(sillas[i].getEtiqueta());
                if (i < sillas.length - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
        System.out.println("Total a pagar: $" + (int) precioTotal);

        return true;
    }

    public String getCliente() {
        return cliente;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public Silla[] getSillas() {
        return sillas;
    }
}