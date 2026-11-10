/**
 * Funciones de INTERFAZ de la prueba "La palabra más larga".
 * Solo muestran información y piden datos.
 *
 * @author Miguel Francisco Fernández
 * @version 1.0
 */

public class interfaz {


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

    // Letras disponibles para la prueba
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

    // Pedir palabra al jugador
    public static String pedirPalabra(int jugador, String letras) {
        String palabra;
        boolean correcta;
        do {
            System.out.print("Jugador " + jugador + ", introduce tu palabra: ");
            palabra = Main.sc.nextLine().trim();
            correcta = false;

            if (!lógica.contieneSoloLetras(palabra)) {
                System.out.println("Error: escribe una sola palabra, solo con letras.");
            } else if (!lógica.esValidaPorLetras(palabra, letras)) {
                System.out.println("Error: esa palabra no se puede formar con las letras disponibles.");
            } else {
                correcta = true;
            }
        } while (!correcta);
        return palabra;
    }

// Resultado Final
    public static void mostrarResultadoFinal(int jugador1, int jugador2, int ganador) {
        System.out.println("\n===== RESULTADO FINAL =====");
        System.out.println("Jugador 1: " + jugador1 + " letras");
        System.out.println("Jugador 2: " + jugador2 + " letras");
        if (ganador == 0) {
            System.out.println("Empate entre Jugador 1 y Jugador 2.");
        } else {
            System.out.println("Gana el jugador " + ganador);
        }
    }

    // Hacer funcionar la prueba de letras
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

}