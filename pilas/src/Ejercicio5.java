import java.util.Stack;

public class Ejercicio5 {
    public static void main(String[] args) {
        String frase = "reconocer";
        String fraseLimpia = frase.toLowerCase().replaceAll("\\s+", "");

        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < fraseLimpia.length(); i++) {
            pila.push(fraseLimpia.charAt(i));
        }

        boolean esPalindromo = true;

        for (int i = 0; i < fraseLimpia.length(); i++) {
            char caracterDelFinal = pila.pop();
            char caracterDelInicio = fraseLimpia.charAt(i);

            if (caracterDelFinal != caracterDelInicio) {
                esPalindromo = false;
                break;
            }
        }

        if (esPalindromo) {
            System.out.println("La frase \"" + frase + "\" ES un palíndromo.");
        } else {
            System.out.println("La frase \"" + frase + "\" NO es un palíndromo.");
        }
    }
}
