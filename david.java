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
        }if(n1 % n2 != 0){
            validador = false;
        }else{
            System.out.println(resultado);
        }
        return validador;
    }

    // Calculo entre la respuesta de los jugadores y el resultado final
    public static int calculoDiferencial(int objetivo, int resultado){
        return Math.abs(objetivo - resultado);
    }

    // Ganador de la cifra exacta
    public static int ganadorCifraExacta(int objetivo, int resultadoJ1, int resultadoJ2){
        int diferenciaJ1 = calculoDiferencial(objetivo, resultadoJ1);
        int diferenciaJ2 = calculoDiferencial(objetivo, resultadoJ2);
        if(diferenciaJ1 < diferenciaJ2){
            return 1; // El jugador 1 gana
        }else if(diferenciaJ2 < diferenciaJ1){
            return 2; // El jugador 2 gana
        }else{
            return 0; // Empate entre los dos jugadores
        }
    }

    /**
     * La calculadora humana
     * @author David Espejo Piñero
     * @version 1.0
     */

    // Generador del primer numero para las operaciones
    public static int generarorAleatorioCalculadora(){
        int numero = rd.nextInt(2,101);
        return numero;
    }

    // Generador para los numeros posteriores para las siguientes operaciones
    public static int generadorSecundario(char operador){
        int numero;
        if(operador == '+' || operador == '-'){
            numero = rd.nextInt(11,100);
            return numero;
        }else{ 
            numero = rd.nextInt(2,10);
            return numero;
        }
    }

    // Inicio y continuacion de los diferentes resultados matematico
    public static int calcularResultado(int numeroActual, char operador, int valorSecundario){
        int resultado;
        switch (operador) {
            case '+':
                resultado = numeroActual + valorSecundario;
                return resultado;
            case '-':
                resultado = numeroActual - valorSecundario;
                return resultado;
            case '*':
                resultado = numeroActual * valorSecundario;
                return resultado;
            case '/':
                resultado = numeroActual / valorSecundario;
                return resultado;
            default:
                return numeroActual;
        }
    }

    // Validacion de la respuesta del jugador
    public static boolean esRespuestaCorrecta(int respuestaUsuario, int resultado){
        boolean respuesta = true;
        if(respuestaUsuario != resultado){
            respuesta = false;
        }
        return respuesta;
    }

    // Calculo del tiempo final del jugador y aplicar la penalizacion en caso de fallo
    public static long tiempoFinal(long tiempoActual, boolean esCorrecta){
        if(!esCorrecta){
            long tiempoFinal = tiempoActual + 20;
            return tiempoFinal;
        }
        return tiempoActual;
    }

}
