import java.util.Scanner;
import java.util.Random;

public class lógica {
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    static int cantidadLetras = 10;
    static int puntosTotalesJ1 = 0;
    static int puntosTotalesJ2 = 0;

    public static String generarLetras() {
        String vocales = "AEIOU";
        String consonantes = "BCDFGHJKLMNÑPQRSTVWXYZ";

        int numVocales = 4 + rd.nextInt(3);
        int numConsonantes = cantidadLetras - numVocales;

        String letrasSeleccionadas = "";

        for (int i = 0; i < numVocales; i++) {
            int index = rd.nextInt(vocales.length());
            letrasSeleccionadas += vocales.charAt(index);
        }

        for (int i = 0; i < numConsonantes; i++) {
            int index = rd.nextInt(consonantes.length());
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

    public static int ganadorLetras(int longitudJ1, int longitudJ2) {
    if (longitudJ1 > longitudJ2) {
        return 1;
    } else if (longitudJ2 > longitudJ1) {
        return 2;
    } else {
        return 0;
    }
}

public static boolean contieneSoloLetras(String texto) {
    if (texto.length() == 0) {
        return false;
    }
    for (int i = 0; i < texto.length(); i++) {
        if (!Character.isLetter(texto.charAt(i))) {
            return false;
        }
    }
    return true;
}

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
        if(min == 0){
            validador = false;
        }
        int resultado = max / min;
        if(n1 % n2 != 0){
            validador = false;
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
        int numero = rd.nextInt(1,101);
        return numero;
    }

    // Generador para los numeros posteriores para las siguientes operaciones
    public static int generadorSecundario(char operador){
        int numero;
        if(operador == '+' || operador == '-'){
            numero = rd.nextInt(10,100);
            return numero;
        }else{ 
            numero = rd.nextInt(1,10);
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
        return respuestaUsuario == resultado;
    }

    // Calculo del tiempo final del jugador y aplicar la penalizacion en caso de fallo
    public static long tiempoFinal(long tiempoActual, boolean esCorrecta){
        if(!esCorrecta){
            long tiempoFinal = tiempoActual + 20;
            return tiempoFinal;
        }
        return tiempoActual;
    }

    // Ganador de la prueba Calculadora Mental
    public static int ganadorCalculadora(long tiempoJ1, long tiempoJ2){
        int ganador;
        if(tiempoJ1 < tiempoJ2){
            ganador = 1;
            return ganador;
        }else if(tiempoJ2 < tiempoJ1){
            ganador = 2;
            return ganador;
        }else{
            //En caso de empate
            ganador = 0;
            return ganador;
        }
    }

    public static void actualizarMarcardorGlobal(int ganador){
        if(ganador == 1){
            puntosTotalesJ1 ++;
        }else if(ganador == 2){
            puntosTotalesJ2 ++;
        }
        // Si es empate nadie suma punto
    }
}


