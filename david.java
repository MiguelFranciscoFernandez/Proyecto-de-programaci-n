import java.util.Random;

public class david {
    
    static Random rd = new Random();
    
    /**
     * LA CIFRA EXACTA
     * @author David Espejo Piñero
     * @version 1.0
     */

    // Generador de numeros aleatorios
    public static int generarNumeroAleatorio(){
        int numero = rd.nextInt(1, 101);
        return numero;
    }

    // Generador de numeros auxiliares
    public static int generarNumeroAuxiliar(){
        int auxiliar = rd.nextInt(1,11);
        return auxiliar;
    }

    

}
