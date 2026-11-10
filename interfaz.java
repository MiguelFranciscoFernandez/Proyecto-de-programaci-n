/**
 * Funciones de INTERFAZ de la prueba "La palabra más larga".
 * Solo muestran información y piden datos.
 *
 * @author Miguel Francisco Fernández
 * @version 1.0
 */

public class interfaz {

    public static int ejecutarPruebaLetras(String letrasDisponibles) {
        int longitud1 = 0;
        int longitud2 = 0;

        System.out.print("Jugador 1, introduce una palabra: ");
        String palabra1 = Main.sc.nextLine();
        if (lógica.esValidaPorLetras(palabra1, letrasDisponibles)) {
            System.out.println("Jugador 1, tu palabra es válida.");
            longitud1 = palabra1.length();
        } else {
            System.out.println("Jugador 1, tu palabra no es válida.");
        }

        System.out.print("Jugador 2, introduce una palabra: ");
        String palabra2 = Main.sc.nextLine();
        if (lógica.esValidaPorLetras(palabra2, letrasDisponibles)) {
            System.out.println("Jugador 2, tu palabra es válida.");
            longitud2 = palabra2.length();
        } else {
            System.out.println("Jugador 2, tu palabra no es válida.");
        }

        int ganador = lógica.ganadorLetras(longitud1, longitud2);
        if (ganador == 0) {
            System.out.println("Empate entre Jugador 1 y Jugador 2.");
        } else {
            System.out.println("Gana el jugador " + ganador);
        }
        return ganador;
    }

    public static void mostrarBienvenida() {
        System.out.println("Bienvenido a la prueba 'La palabra más larga'.");
        System.out.println("Dos jugadores competirán para formar la palabra más larga posible.");
    }

    public static void mostrarInstrucciones() {
        System.out.println("Instrucciones:");
        System.out.println("1. Cada jugador debe introducir una palabra utilizando las letras disponibles.");
        System.out.println("2. La palabra debe ser válida y contener solo las letras proporcionadas.");
        System.out.println("3. El jugador con la palabra más larga gana la ronda.");
    }

    public static void mostrarLetras(String letras) {
        String separadas = "";
        for (int i = 0; i < letras.length(); i++) {
            separadas += letras.charAt(i) + " ";
        }
        System.out.println("\n===== LA PALABRA MÁS LARGA =====");
        System.out.println("Letras disponibles:");
        System.out.println("   " + separadas.trim());
        System.out.println();
    }

}
