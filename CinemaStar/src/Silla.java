public class Silla {

    private String etiqueta;
    private boolean preferencial;
    private boolean ocupada;

    public Silla(String etiqueta, boolean preferencial) {
        this.etiqueta = etiqueta;
        this.preferencial = preferencial;
        this.ocupada = false;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public boolean esPreferencial() {
        return preferencial;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public void ocupar() {
        ocupada = true;
    }

    public void liberar() {
        ocupada = false;
    }

}