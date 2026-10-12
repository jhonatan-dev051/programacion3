import java.util.Stack;

public class Ejercicio2 {
    public static void main(String[] args) {

        String expresion1 = "((a+b)*5) - 7";
        String expresion2 = "2*[(a+b)/2.5 + x - 7*y";

        System.out.println("Expresión 1 equilibrada: " + verificarEquilibrio(expresion1));
        System.out.println("Expresión 2 equilibrada: " + verificarEquilibrio(expresion2));
    }

    public static boolean verificarEquilibrio(String expresion) {

        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            }

            else if (c == ')' || c == '}' || c == ']') {

                if (pila.isEmpty()) {
                    return false;
                }

                char ultimo = pila.pop();

                if ((c == ')' && ultimo != '(') ||
                        (c == '}' && ultimo != '{') ||
                        (c == ']' && ultimo != '[')) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }
}