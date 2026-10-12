import java.util.Stack;

public class Ejercicio1 {
	public static void main(String[] args) throws Exception {
		String entrada = "abc&cba";

		Stack<String> pila = new Stack<>();

		int i = 0;
		int n = entrada.length();

		while (i < n && entrada.charAt(i) != '&') {
			String caracter = String.valueOf(entrada.charAt(i));
			pila.push(caracter);
			i++;
		}

		if (i == n) {
			System.out.println("La cadena '" + entrada + "' NO tiene el formato X & Y (falta el '&').");
			return;
		}

		i++;

		boolean esValido = true;

		while (i < n) {

			if (pila.isEmpty()) {
				esValido = false;
				break;
			}

			System.out.println("Cima actual antes de comparar: " + pila.peek());

			String eliminado = pila.pop();
			System.out.println("Eliminado de la pila: " + eliminado);

			String caracterActual = String.valueOf(entrada.charAt(i));
			if (!caracterActual.equals(eliminado)) {
				esValido = false;
				break;
			}

			i++;
		}

		if (esValido && pila.isEmpty()) {
			System.out.println("Resultado: La cadena '" + entrada + "' SI tiene la forma X & Y.");
		} else {
			System.out.println("Resultado: La cadena '" + entrada + "' NO tiene la forma X & Y.");
		}
	}
}