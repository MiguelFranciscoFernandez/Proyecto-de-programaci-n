import java.util.Scanner;
import java.util.Random;

public class lógica {
    private static Scanner sc = new Scanner(System.in);
    private static Random rd = new Random();
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

}
