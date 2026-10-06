public class Sala {

    private String nombre;
    private Silla[][] sillas;
    private String[] filas;

    public Sala(String nombre) {
        this.nombre = nombre;
        this.sillas = new Silla[8][12];
        this.filas = new String[] { "A", "B", "C", "D", "E", "F", "G", "H" };

        this.llenarSillas();
    }

    public void llenarSillas() {
        for (int i = 0; i < this.sillas.length; i++) {
            for (int j = 0; j < this.sillas[i].length; j++) {
                String etiqueta = filas[i] + (j + 1);
                boolean preferencial = i >= 6;
                sillas[i][j] = new Silla(etiqueta, preferencial);
            }
        }
    }

    public void mostrarSillas() {
        System.out.println("\n" + nombre);
        for (int i = 0; i < this.sillas.length; i++) {
            for (int j = 0; j < this.sillas[i].length; j++) {
                if (sillas[i][j] != null) {
                    System.out.print(sillas[i][j].getEtiqueta() + " ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }

    public Silla buscarSillaPorEtiqueta(String etiqueta) {
        if (etiqueta == null || etiqueta.trim().isEmpty()) {
            return null;
        }

        for (int i = 0; i < sillas.length; i++) {
            for (int j = 0; j < sillas[i].length; j++) {

                if (sillas[i][j] != null && sillas[i][j].getEtiqueta().equalsIgnoreCase(etiqueta.trim())) {
                    return sillas[i][j];
                }
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public Silla[][] getSillas() {
        return sillas;
    }
}