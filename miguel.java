import java.util.Scanner;
import java.util.Random;

/**
 * Clase que representa a la parte de letras
 * 
 * @author Miguel Francisco Fernández
 * @version 1.0
 */

public class miguel {

    // Variables globales
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static int cantidadLetras = 10;
    static int puntosPruebaJ1 = 0;
    static int puntosPruebaJ2 = 0;
    static int puntosTotalesJ1 = 0;
    static int puntosTotalesJ2 = 0;

    public static String generarLetras() {
        String vocales = "AEIOU";
        String consonantes = "BCDFGHJKLMNÑPQRSTVWXYZ";

        int numVocales = 4 + rand.nextInt(3);
        int numConsonantes = cantidadLetras - numVocales;

        String letrasSeleccionadas = "";

        for (int i = 0; i < numVocales; i++) {
            int index = rand.nextInt(vocales.length());
            letrasSeleccionadas += vocales.charAt(index);
        }

        for (int i = 0; i < numConsonantes; i++) {
            int index = rand.nextInt(consonantes.length());
            letrasSeleccionadas += consonantes.charAt(index);
        }

        return letrasSeleccionadas;
    }

    public static boolean esValidaPorLetras(String palabra, String letrasDisponibles) {
        palabra = palabra.toUpperCase();
        String letrasDispCopia = letrasDisponibles;

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            int indiceEnCopia = letrasDispCopia.indexOf(letra);

            if (indiceEnCopia != -1) {

                letrasDispCopia = letrasDispCopia.substring(0, indiceEnCopia) +
                        letrasDispCopia.substring(indiceEnCopia + 1);
            } else {
                return false;
            }
        }
        return true;
    }
    // Gestion de flujo del juego para 2 jugadores

    public static int ejecutarPruebaLetras(String letrasDisponibles) {
        System.out.println("Jugador 1, introduce una palabra: ");
        String palabraJugador1 = sc.nextLine();

        if (esValidaPorLetras(palabraJugador1, letrasDisponibles)) {
            System.out.println("Jugador 1, tu palabra es válida.");
        } else {
            System.out.println("Jugador 1, tu palabra no es válida.");
        }

        System.out.println("Jugador 2, introduce una palabra: ");
        String palabraJugador2 = sc.nextLine();

        if (esValidaPorLetras(palabraJugador2, letrasDisponibles)) {
            System.out.println("Jugador 2, tu palabra es válida.");
        } else {
            System.out.println("Jugador 2, tu palabra no es válida.");
        }
        int longitud1 = palabraJugador1.length();
        int longitud2 = palabraJugador2.length();

        int ganador = 0;
        if (longitud1 > longitud2) {
            System.out.println("Jugador 1 gana con la palabra: " + palabraJugador1);
            ganador = 1;
        } else if (longitud2 > longitud1) {
            System.out.println("Jugador 2 gana con la palabra: " + palabraJugador2);
            ganador = 2;
        } else {
            System.out.println("Empate entre Jugador 1 y Jugador 2.");
        }

        return ganador;
    }

    public static void main(String[] args) {
        String letras = generarLetras();
        System.out.println("Letras generadas: " + letras);

        ejecutarPruebaLetras(letras);
    }

}
