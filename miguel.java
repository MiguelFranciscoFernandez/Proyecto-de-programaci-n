import java.util.Scanner;
import java.util.Random;

/**
 * Clase que representa a la parte de letras
 * 
 * @author Miguel Francisco Fernández
 * @version 1.0
 */


public class miguel {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static String generarLetras() {
        String vocales = "AEIOU";
        String consonantes = "BCDFGHJKLMNÑPQRSTVWXYZ";

        int numVocales = 4 + rand.nextInt(3);
        int numConsonantes = 10 - numVocales;

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

    public static void main(String[] args) {
        String letras = generarLetras();
        System.out.println("Letras generadas: " + letras);

    }

}
