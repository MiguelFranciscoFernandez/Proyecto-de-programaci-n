import java.util.Scanner;
import java.util.Random;

public class lógica {
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    static int cantidadLetras = 10;
    static int puntosTotalesJ1 = 0;
    static int puntosTotalesJ2 = 0;
    static int segundosMaximos = 300;

    // Generador de pruebas aleatorias para el modo rapido
    public static int generarPruebaAleatoria() {
        return rd.nextInt(1, 5); 
    }

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

    
    // Funcion para que se pueda jugar a la letra mas larga
    public static int jugarPalabraMasLarga() {
        interfaz.mostrarBienvenida();
        interfaz.mostrarInstrucciones();
        String letras = generarLetras();
        interfaz.mostrarLetras(letras);
        int ganador = interfaz.ejecutarPruebaLetras(letras);
        return ganador;
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

    public static int ganadorLetras(int longitudJ1, int longitudJ2) {
        if (longitudJ1 > longitudJ2) {
            return 1;
        } else if (longitudJ2 > longitudJ1) {
            return 2;
        } else {
            return 0;
        }
    }

    /**
     * LA CIFRA EXACTA
     * @author David Espejo Piñero
     * @version 1.0
     */

    // Generador de numeros aleatorios
    public static int generarNumeroAleatorio() {
        int numero = rd.nextInt(101, 1000);
        return numero;
    }

    // Generador de numeros auxiliares
    public static int generarNumeroAuxiliar() {
        int auxiliar = rd.nextInt(1, 11);
        return auxiliar;
    }

    // Generador de números auxiliares para la Cifra exacta
    public static String generarNumerosAuxiliares() {
        int aux1 = generarNumeroAuxiliar();
        int aux2 = generarNumeroAuxiliar();
        int aux3 = generarNumeroAuxiliar();
        int aux4 = generarNumeroAuxiliar();
        int aux5 = generarNumeroAuxiliar();
        int aux6 = generarNumeroAuxiliar();
        return aux1 + ", " + aux2 + ", " + aux3 + ", " + aux4 + ", " + aux5 + ", " + aux6;
    }

    // Validador de operaciones aritmetricas
    public static boolean validarDivision(int n1, int n2) {
        boolean validador = true;
        int min = Math.min(n1, n2);
        if (min == 0) {
            validador = false;
        }
        if (n1 % n2 != 0) {
            validador = false;
        }
        return validador;
    }

    // Funcion para que se pueda jugar la Cifra Exacta
    public static int jugarCifraExacta() {
        interfaz.mostrarBienvenidaCifraExacta();
        interfaz.mostrarInstruccionesCifraExacta();
        int objetivo = generarNumeroAleatorio();
        String auxiliares = generarNumerosAuxiliares();
        interfaz.mostrarCifraExacta(objetivo, auxiliares);
        System.out.println("Jugador 1:");
        int resultadoJ1 = interfaz.pruebaCifraExacta(objetivo, auxiliares);
        System.out.println("Jugador 2:");
        int resultadoJ2 = interfaz.pruebaCifraExacta(objetivo, auxiliares);
        int diferenciaJ1 = calculoDiferencial(objetivo, resultadoJ1);
        int diferenciaJ2 = calculoDiferencial(objetivo, resultadoJ2);
        int puntosJ1 = calcularPuntosCifraExacta(diferenciaJ1);
        int puntosJ2 = calcularPuntosCifraExacta(diferenciaJ2);
        interfaz.mostrarGanadorCifraExacta(puntosJ1, puntosJ2);
        int ganador = ganadorCifraExacta(objetivo, resultadoJ1, resultadoJ2);
        return ganador;
    }

    // Calculo entre la respuesta de los jugadores y el resultado final
    public static int calculoDiferencial(int objetivo, int resultado) {
        return Math.abs(objetivo - resultado);
    }

    // Ganador de la cifra exacta
    public static int ganadorCifraExacta(int objetivo, int resultadoJ1, int resultadoJ2) {
        int diferenciaJ1 = calculoDiferencial(objetivo, resultadoJ1);
        int diferenciaJ2 = calculoDiferencial(objetivo, resultadoJ2);
        if (diferenciaJ1 < diferenciaJ2) {
            return 1; // El jugador 1 gana
        } else if (diferenciaJ2 < diferenciaJ1) {
            return 2; // El jugador 2 gana
        } else {
            return 0; // Empate entre los dos jugadores
        }
    }

    /**
     * La calculadora humana
     * @author David Espejo Piñero
     * @version 1.0
     */

    // Generador del primer numero para las operaciones
    public static int generarorAleatorioCalculadora() {
        int numero = rd.nextInt(1, 101);
        return numero;
    }

    // Generador para los numeros posteriores para las siguientes operaciones
    public static int generadorSecundario(char operador) {
        int numero;
        if (operador == '+' || operador == '-') {
            numero = rd.nextInt(10, 100);
            return numero;
        } else {
            numero = rd.nextInt(1, 10);
            return numero;
        }
    }

    // Funcion para que se pueda jugar a la Calculadora Humana
    public static int jugarCalculadoraHumana() {
        interfaz.mostrarBienvenidaCalculadora();
        int totalOperaciones = 5;
        interfaz.mostrarInstruccionesCalculadora(totalOperaciones);

        long tiempoJ1 = interfaz.jugarTurnoCalculadora(1, totalOperaciones);
        long tiempoJ2 = interfaz.jugarTurnoCalculadora(2, totalOperaciones);

        interfaz.mostrarGanadorCalculadora((int) tiempoJ1, (int) tiempoJ2);

        int ganador = lógica.ganadorCalculadora(tiempoJ1, tiempoJ2);
        interfaz.mostrarGanadorPrueba(ganador);
        int puntosJ1 = lógica.calcularPuntosIndividualCalculadora(tiempoJ1);
        int puntosJ2 = lógica.calcularPuntosIndividualCalculadora(tiempoJ2);
        interfaz.mostrarMarcadorPrueba(puntosJ1, puntosJ2);

        // Sumar al marcador global
        Main.puntosTotalesJ1 += puntosJ1;
        Main.puntosTotalesJ2 += puntosJ2;

        return ganador;
    }

    // Inicio y continuacion de los diferentes resultados matematico
    public static int calcularResultado(int numeroActual, char operador, int valorSecundario) {
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
    public static boolean esRespuestaCorrecta(int respuestaUsuario, int resultado) {
        return respuestaUsuario == resultado;
    }

    // Calculo del tiempo final del jugador y aplicar la penalizacion en caso de
    // fallo
    public static long tiempoFinal(long tiempoActual, boolean esCorrecta) {
        if (!esCorrecta) {
            long tiempoFinal = tiempoActual + 20;
            return tiempoFinal;
        }
        return tiempoActual;
    }

    // Ganador de la prueba Calculadora Mental
    public static int ganadorCalculadora(long tiempoJ1, long tiempoJ2) {
        int ganador;
        if (tiempoJ1 < tiempoJ2) {
            ganador = 1;
            return ganador;
        } else if (tiempoJ2 < tiempoJ1) {
            ganador = 2;
            return ganador;
        } else {
            // En caso de empate
            ganador = 0;
            return ganador;
        }
    }

    public static void actualizarMarcardorGlobal(int ganador) {
        if (ganador == 1) {
            puntosTotalesJ1++;
        } else if (ganador == 2) {
            puntosTotalesJ2++;
        }
        // Si es empate nadie suma punto
    }

    /**
     * Cronus Rumanus
     * @author David
     * @version 1.0
     * En esta prueba se mostrara un numero desde 1 hata el 3999 en romano y el jugador tendra que adivinar la mayor cantidad posible
     * de numeros en un minuto.
     */
    // Geerar un numero romano entre 1 y 3999
    public static int generarNumeroRomano() {
        int romano = rd.nextInt(1, 4000);
        return romano;
    }

    // Funcion para que se pueda jugar Cronus Rumanus
    public static int jugarCronusRumanus() {
        interfaz.mostrarBienvenidaCronus();
        interfaz.mostrarInstruccionesCronus();
        int preguntasPorJugador = 3;
        int aciertosJ1 = interfaz.jugarTurnoCronus(1, preguntasPorJugador);
        int aciertosJ2 = interfaz.jugarTurnoCronus(2, preguntasPorJugador);

        interfaz.mostrarGanadorCronus(aciertosJ1, aciertosJ2);

        int ganador = lógica.ganadorCronusRuma(aciertosJ1, aciertosJ2);
        interfaz.mostrarGanadorPrueba(ganador);

        // Puntos en funcion de los aciertos de numeros romanos
        int puntosJ1 = lógica.calcularPuntosCronusRomanus(aciertosJ1);
        int puntosJ2 = lógica.calcularPuntosCronusRomanus(aciertosJ2);
        interfaz.mostrarMarcadorPrueba(puntosJ1, puntosJ2);

        // Sumar al marcador global
        Main.puntosTotalesJ1 += puntosJ1;
        Main.puntosTotalesJ2 += puntosJ2;

        return ganador;
    }

    public static String convertirARomano(int numero) {
        int unidades = numero % 10;
        int decenas = (numero / 10) % 10;
        int centenas = (numero / 100) % 10;
        int millares = (numero / 1000) % 10;

        String romanoMillares = "";
        romanoMillares.toUpperCase();
        switch (millares) {
            case 1:
                romanoMillares = "M";
                break;
            case 2:
                romanoMillares = "MM";
                break;
            case 3:
                romanoMillares = "MMM";
                break;
        }

        String romanoCentenas = "";
        romanoCentenas.toUpperCase();
        switch (centenas) {
            case 1:
                romanoCentenas = "C";
                break;
            case 2:
                romanoCentenas = "CC";
                break;
            case 3:
                romanoCentenas = "CCC";
                break;
            case 4:
                romanoCentenas = "CD";
                break;
            case 5:
                romanoCentenas = "D";
                break;
            case 6:
                romanoCentenas = "DC";
                break;
            case 7:
                romanoCentenas = "DCC";
                break;
            case 8:
                romanoCentenas = "DCCC";
                break;
            case 9:
                romanoCentenas = "CM";
                break;
        }

        String romanoDecenas = "";
        romanoDecenas.toUpperCase();
        switch (decenas) {
            case 1:
                romanoDecenas = "X";
                break;
            case 2:
                romanoDecenas = "XX";
                break;
            case 3:
                romanoDecenas = "XXX";
                break;
            case 4:
                romanoDecenas = "XL";
                break;
            case 5:
                romanoDecenas = "L";
                break;
            case 6:
                romanoDecenas = "LX";
                break;
            case 7:
                romanoDecenas = "LXX";
                break;
            case 8:
                romanoDecenas = "LXXX";
                break;
            case 9:
                romanoDecenas = "XC";
                break;
        }

        String romanoUnidades = "";
        romanoUnidades.toUpperCase();
        switch (unidades) {
            case 1:
                romanoUnidades = "I";
                break;
            case 2:
                romanoUnidades = "II";
                break;
            case 3:
                romanoUnidades = "III";
                break;
            case 4:
                romanoUnidades = "IV";
                break;
            case 5:
                romanoUnidades = "V";
                break;
            case 6:
                romanoUnidades = "VI";
                break;
            case 7:
                romanoUnidades = "VII";
                break;
            case 8:
                romanoUnidades = "VIII";
                break;
            case 9:
                romanoUnidades = "IX";
                break;
        }

        return romanoMillares + romanoCentenas + romanoDecenas + romanoUnidades;
    }


    // Ganador de Conus Rumanus
    public static int ganadorCronusRuma(int aciertosJ1, int aciertosJ2) {
        int ganador;
        if (aciertosJ1 > aciertosJ2) {
            ganador = 1;
            return ganador;
        } else if (aciertosJ2 > aciertosJ1) {
            ganador = 2;
            return ganador;
        } else {
            // En caso de empate
            ganador = 0;
            return ganador;
        }
    }

    /**
     * Sistema de puntuacion de las pruebas matematicas y decision del ganador del juego
     * @author David Espejo Piñero
     * @version 2.0
     */

    // Sistema de puntuacion de la Cifra Exacta
    public static int calcularPuntosCifraExacta(int diferencia) {
        if (diferencia == 0) {
            return 10;
        } else if (diferencia <= 5) {
            return 5;
        } else if (diferencia <= 10) {
            return 3;
        } else {
            return 1;
        }
    }

    // Sistema de puntuacion de la calculadora
    public static int calcularPuntosIndividualCalculadora(long tiempoFinalJugador) {
        int basePuntuacion = 300;
        int puntos = basePuntuacion - (int) tiempoFinalJugador;
        return (puntos > 0) ? puntos : 0; // Si es negativo por tardar mucho, se queda en 0
    }

    // Sistema de puntuacion de Cronus Rumanus
    public static int calcularPuntosCronusRomanus(int aciertosJugador) {
        return aciertosJugador;
    }

    // Actualizador del marcador global de los jugadores
    public static void actualizarMarcardorGlobal(int puntosPruebaJ1, int puntosPruebaJ2) {
        puntosTotalesJ1 += puntosPruebaJ1;
        puntosTotalesJ2 += puntosPruebaJ2;
    }

    // Actualizar la puntuación tras una prueba
    public static void actualizarPuntuacion(int ganador) {
        interfaz.mostrarGanadorPrueba(ganador);
        if (ganador == 1) {
            Main.puntosTotalesJ1++;
        } else if (ganador == 2) {
            Main.puntosTotalesJ2++;
        }
    }

    //Ganador del concuros
    public static int ganadorConcurso(int puntosTotalesJ1, int puntosTotalesJ2){
        if(puntosTotalesJ1 > puntosTotalesJ2){
            return 1;
        }else if(puntosTotalesJ2 > puntosTotalesJ1){
            return 2;
        }else{
            return 0;
        }
    }
}
