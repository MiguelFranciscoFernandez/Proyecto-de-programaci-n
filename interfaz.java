/**
 * Funciones de INTERFAZ de la prueba "La palabra más larga".
 * Solo muestran información y piden datos.
 *
 * @author Miguel Francisco Fernández
 * @version 1.0
 */

public class interfaz {

    // Menu principal

    public static int mostrarMenuPrincipal() {
        System.out.println("\n===== CIFRAS Y LETRAS =====");
        System.out.println("1. Modo concurso (todas las pruebas)");
        System.out.println("2. Modo rápido (una sola prueba)");
        System.out.println("3. Salir");
        return pedirOpcion(1, 3);
    }

    // Pedir opción al usuario
    public static int pedirOpcion(int min, int max) {
        int opcion = 0;
        boolean correcta = false;

        do {
            System.out.print("Selecciona una opción: ");
            try {
                opcion = Integer.parseInt(Main.sc.nextLine());
                if (opcion >= min && opcion <= max) {
                    correcta = true;
                } else {
                    System.out.println("Opción no válida. Elige un número del " + min + " al " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida. Elige un número del " + min + " al " + max + ".");
            }
        } while (!correcta);

        return opcion;
    }

    // Menu del modo rápido: devuelve 1-4 (prueba elegida) o 5 (volver)
    public static int mostrarMenuModoRapido() {
        System.out.println("\n===== MODO RÁPIDO =====");
        System.out.println("Elige la prueba que quieres jugar:");
        System.out.println("1. La palabra más larga");
        System.out.println("2. La cifra exacta");
        System.out.println("3. La calculadora humana");
        System.out.println("4. Cronus Rumanus");
        System.out.println("5. Volver al menú principal");
        return pedirOpcion(1, 5);
    }



    // --- Palabra más larga ---

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

    // ---------- LA CIFRA EXACTA ----------

    public static void mostrarBienvenidaCifraExacta() {
        System.out.println("Bienvenido a la prueba 'La cifra exacta'.");
        System.out.println("Dos jugadores competirán para acercarse lo máximo posible a un número objetivo.");
    }

    public static void mostrarInstruccionesCifraExacta() {
        System.out.println("\n===== LA CIFRA EXACTA =====");
        System.out.println("Instrucciones:");
        System.out.println("1. Debes acercarte lo máximo posible al número objetivo.");
        System.out.println("2. Tienes " + "OPERACIONES_CIFRA" + " operaciones: + - * /");
        System.out.println("3. En la primera operación eliges dos números de los disponibles.");
        System.out.println("4. En las siguientes usas el resultado anterior y un número disponible.");
        System.out.println("5. Puedes repetir un mismo número disponible las veces que quieras.");
        System.out.println("6. Las divisiones deben ser exactas y no se puede dividir entre cero.");
    }

    // Número objetivo y números disponibles
    public static void mostrarCifraExacta(int objetivo, String auxiliares) {
        System.out.println("\nNúmero objetivo: " + objetivo);
        System.out.println("Números disponibles: " + auxiliares.replace(",", "  "));
        System.out.println();
    }

    public static void mostrarOperacionCifraExacta(int numeroOperacion, int cantidadOperaciones, int numeroActual,
            char operador, int valor) {
        System.out.println("\nOperación " + numeroOperacion + " de " + cantidadOperaciones);
        System.out.print(numeroActual + " " + operador + " " + valor + " = ");
    }

    public static int pedirResultadoCifraExacta(int numeroOperacion, int cantidadOperaciones, int numeroActual,
            char operador, int valor) {
        int resultado = 0;
        boolean correcto = false;

        do {
            System.out.print("Introduce tu resultado: ");
            String input = Main.sc.nextLine().trim();
            try {
                resultado = Integer.parseInt(input);
                correcto = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un número válido.");
            }
        } while (!correcto);

        return resultado;
    }

    public static int pruebaCifraExacta(int objetivo, String auxiliares) {
        int resultado = 0;
        boolean correcto = false;

        do {
            System.out.print("Introduce tu resultado: ");
            String input = Main.sc.nextLine().trim();
            try {
                resultado = Integer.parseInt(input);
                correcto = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un número válido.");
            }
        } while (!correcto);

        return resultado;
    }

    public static void mostrarGanadorCifraExacta(int jugador1, int jugador2) {
        System.out.println("\n===== RESULTADO FINAL =====");
        System.out.println("Jugador 1: " + jugador1 + " puntos");
        System.out.println("Jugador 2: " + jugador2 + " puntos");
        if (jugador1 > jugador2) {
            System.out.println("Gana el jugador 1");
        } else if (jugador2 > jugador1) {
            System.out.println("Gana el jugador 2");
        } else {
            System.out.println("Empate entre Jugador 1 y Jugador 2.");
        }
    }

    // ---------- LA CALCULADORA HUMANA ----------

    public static void mostrarBienvenidaCalculadora() {
        System.out.println("Bienvenido a la prueba 'La calculadora humana'.");
        System.out.println("Dos jugadores competirán para resolver operaciones matemáticas de cabeza.");
    }

    public static void mostrarInstruccionesCalculadora(int cantidadOperaciones) {
        System.out.println("\n===== LA CALCULADORA HUMANA =====");
        System.out.println("Instrucciones:");
        System.out.println("1. Cada jugador resuelve " + cantidadOperaciones + " operaciones de cabeza.");
        System.out.println("2. El resultado correcto es el número de partida de la siguiente operación,");
        System.out.println("   aunque hayas fallado.");
        System.out.println("3. Gana quien termine en menos tiempo.");
        System.out.println("4. Cada respuesta incorrecta suma 20 segundos de penalización.");
    }

    // Operación que tiene que resolver el jugador
    public static void mostrarOperacion(int numeroOperacion, int cantidadOperaciones, int numeroActual, char operador,
            int valor) {
        System.out.println("\nOperación " + numeroOperacion + " de " + cantidadOperaciones);
        System.out.print(numeroActual + " " + operador + " " + valor + " = ");
    }

    public static int pedirResultado(int numeroOperacion, int cantidadOperaciones, int numeroActual, char operador,
            int valor) {
        int resultado = 0;
        boolean correcto = false;

        do {
            System.out.print("Introduce tu resultado: ");
            String input = Main.sc.nextLine().trim();
            try {
                resultado = Integer.parseInt(input);
                correcto = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un número válido.");
            }
        } while (!correcto);
        return resultado;
    }

    public static int pruebaCalculadora(int numeroOperacion, int cantidadOperaciones, int numeroActual, char operador,
            int valor) {
        int resultado = 0;
        boolean correcto = false;

        do {
            System.out.print("Introduce tu resultado: ");
            String input = Main.sc.nextLine().trim();
            try {
                resultado = Integer.parseInt(input);
                correcto = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: introduce un número válido.");
            }
        } while (!correcto);

        return resultado;
    }

    public static void mostrarGanadorCalculadora(int jugador1, int jugador2) {
        System.out.println("\n===== RESULTADO FINAL =====");
        System.out.println("Jugador 1: " + jugador1 + " segundos");
        System.out.println("Jugador 2: " + jugador2 + " segundos");
        if (jugador1 < jugador2) {
            System.out.println("Gana el jugador 1");
        } else if (jugador2 < jugador1) {
            System.out.println("Gana el jugador 2");
        } else {
            System.out.println("Empate entre Jugador 1 y Jugador 2.");
        }
    }

    // ---------- CRONUS RUMANUS ----------

    public static void mostrarBienvenidaCronus() {
        System.out.println("Bienvenido a la prueba 'Cronus Rumanus'.");
        System.out.println("Dos jugadores competirán para convertir números romanos a cifras normales.");
    }

    public static void mostrarInstruccionesCronus() {
        System.out.println("\n===== CRONUS RUMANUS =====");
        System.out.println("Instrucciones:");
        System.out.println("1. Se muestra un número romano (del 1 al 3999).");
        System.out.println("2. Debes escribirlo en cifras normales.");
        System.out.println("3. Tienes " + "SEGUNDOS_ROMANOS" + " segundos: gana quien acierte más.");
    }

    // Número romano que tiene que adivinar el jugador
    public static void mostrarNumeroRomano(String romano) {
        System.out.print("\n" + romano + " = ");
    }

    // Pedir la respuesta al jugador
    public static int pedirRespuestaRomano() {
        int respuesta = 0;
        boolean correcta = false;
        do {
            String texto = Main.sc.nextLine().trim();
            try {
                respuesta = Integer.parseInt(texto);
                correcta = true;
            } catch (NumberFormatException e) {
                System.out.print("Error: introduce un número válido: ");
            }
        } while (!correcta);
        return respuesta;
    }

    public static int pruebaCronus(String romano) {
        int respuesta = 0;
        boolean correcta = false;
        do {
            String texto = Main.sc.nextLine().trim();
            try {
                respuesta = Integer.parseInt(texto);
                correcta = true;
            } catch (NumberFormatException e) {
                System.out.print("Error: introduce un número válido: ");
            }
        } while (!correcta);
        return respuesta;
    }

    public static void mostrarGanadorCronus(int jugador1, int jugador2) {
        System.out.println("\n===== RESULTADO FINAL =====");
        System.out.println("Jugador 1: " + jugador1 + " aciertos");
        System.out.println("Jugador 2: " + jugador2 + " aciertos");
        if (jugador1 > jugador2) {
            System.out.println("Gana el jugador 1");
        } else if (jugador2 > jugador1) {
            System.out.println("Gana el jugador 2");
        } else {
            System.out.println("Empate entre Jugador 1 y Jugador 2.");
        }
    }

    // ---------- MARCADORES Y RESULTADOS DEL CONCURSO ----------

    // Marcador de la prueba que se está disputando
    public static void mostrarMarcadorPrueba(int puntosJ1, int puntosJ2) {
        System.out.println("--- Marcador de la prueba ---");
        System.out.println("Jugador 1: " + puntosJ1 + " puntos");
        System.out.println("Jugador 2: " + puntosJ2 + " puntos");
    }

    // Ganador de una prueba (0 = empate)
    public static void mostrarGanadorPrueba(int ganador) {
        if (ganador == 0) {
            System.out.println("La prueba termina en empate: nadie suma punto global.");
        } else {
            System.out.println("El jugador " + ganador + " gana la prueba y suma 1 punto global.");
        }
    }

    // Marcador global del concurso
    public static void mostrarMarcadorGlobal(int puntosJ1, int puntosJ2) {
        System.out.println("--- Marcador global ---");
        System.out.println("Jugador 1: " + puntosJ1 + " puntos");
        System.out.println("Jugador 2: " + puntosJ2 + " puntos");
    }

    // Ganador final del concurso (0 = empate)
    public static void mostrarGanadorConcurso(int ganador) {
        System.out.println("---- FIN DEL CONCURSO ----");
        if (ganador == 0) {
            System.out.println("El concurso termina en empate.");
        } else {
            System.out.println("¡El jugador " + ganador + " gana el concurso!");
        }
    }
}