public class Ejercicio6 {

    static class Nodo {
        String dato;
        Nodo siguiente;
        Nodo anterior;

        public Nodo(String dato) {
            this.dato = dato;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    static class Bicola {
        private Nodo frente;
        private Nodo fin;

        public Bicola() {
            frente = null;
            fin = null;
        }

        public boolean esVacia() {
            return frente == null;
        }

        public void insertarFrente(String dato) {
            Nodo nuevo = new Nodo(dato);
            if (esVacia()) {
                frente = fin = nuevo;
            } else {
                nuevo.siguiente = frente;
                frente.anterior = nuevo;
                frente = nuevo;
            }
        }

        public void insertarFin(String dato) {
            Nodo nuevo = new Nodo(dato);
            if (esVacia()) {
                frente = fin = nuevo;
            } else {
                fin.siguiente = nuevo;
                nuevo.anterior = fin;
                fin = nuevo;
            }
        }

        public String quitarFrente() {
            if (esVacia()) {
                return "La bicola está vacía";
            }
            String dato = frente.dato;
            frente = frente.siguiente;
            if (frente != null) {
                frente.anterior = null;
            } else {
                fin = null;
            }
            return dato;
        }

        public String quitarFin() {
            if (esVacia()) {
                return "La bicola está vacía";
            }
            String dato = fin.dato;
            fin = fin.anterior;
            if (fin != null) {
                fin.siguiente = null;
            } else {
                frente = null;
            }
            return dato;
        }

        public String verFrente() {
            if (esVacia())
                return "La bicola está vacía";
            return frente.dato;
        }

        public String verFin() {
            if (esVacia())
                return "La bicola está vacía";
            return fin.dato;
        }
    }

    public static void main(String[] args) {
        Bicola bicola = new Bicola();

        bicola.insertarFin("Cliente 1");
        bicola.insertarFin("Cliente 2");

        bicola.insertarFrente("Cliente VIP");

        System.out.println("Primero en la fila (Frente): " + bicola.verFrente());
        System.out.println("Último en la fila (Fin): " + bicola.verFin());

        System.out.println("Atendido del frente: " + bicola.quitarFrente());

        System.out.println("Atendido del fin: " + bicola.quitarFin());

        System.out.println("Nuevo primero en la fila: " + bicola.verFrente());
    }
}