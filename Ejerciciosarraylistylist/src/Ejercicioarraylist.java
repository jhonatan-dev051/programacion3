import java.util.ArrayList;
import java.util.List;

public class Ejercicioarraylist {
    public static void main(String[] args) throws Exception {
        ArrayList<String> supermercado = new ArrayList<>();

        supermercado.add("Leche");
        supermercado.add("Pan");
        supermercado.add("Huevos");

    }

    public static void verificarYEliminar(List<String> lista, String productoBuscado) {
        // Condicional: Si NO contiene el producto
        if (!lista.contains(productoBuscado)) {
            System.out.println("Error: El producto \"" + productoBuscado + "\" no se encuentra en la lista.");
            System.out.println("Terminando el programa...");
            System.exit(0);
        }

        // Si sí lo contiene, lo eliminamos de la lista
        lista.remove(productoBuscado);
        System.out.println(" Producto encontrado y eliminado: \"" + productoBuscado + "\".");
        System.out.println(" Lista restante: " + lista);
        System.out.println("-----------------------------------");
    }
}
