import java.util.Scanner;

/**
 * Proyecto Cifras y Letras - Programación 1º DAM
 * @author David Espejo Piñero y Miguel Francisco Fernández
 * @version 1.0
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static int puntosTotalesJ1 = 0;
    public static int puntosTotalesJ2 = 0;

    public static void main(String[] args) {
        int opcion = 0;

        do {
            opcion = interfaz.mostrarMenuPrincipal();

            switch (opcion) {
                case 1:
                    interfaz.jugarModoConcurso();
                    break;
                case 2:
                    interfaz.jugarModoRapido();
                    break;
                case 3:
                    System.out.println("\n¡Gracias por jugar a Cifras y Letras! ¡Hasta la próxima!");
                    break;
                case 99:
                    interfaz.probarTodasLasFunciones();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 3);
    }
}
