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
        int numero = rd.nextInt(101, 1000);
        return numero;
    }

    // Generador de numeros auxiliares
    public static int generarNumeroAuxiliar(){
        int auxiliar = rd.nextInt(1,11);
        return auxiliar;
    }

    // Validador de operaciones aritmetricas
    public static boolean validarDivision(int n1, int n2){
        boolean validador = true;
        int max = Math.max(n1, n2);
        int min = Math.min(n1, n2);
        int resultado = max / min;
        if(min == 0){
            System.out.println("----------------ERROR----------------");
            validador = false;  
        }if(n1 % n2 == 0){
            validador = false;
        }else{
            System.out.println(resultado);
        }
        return validador;
    }

}
