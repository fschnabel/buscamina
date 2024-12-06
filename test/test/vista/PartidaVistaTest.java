package test.vista;

import vista.PartidaVista;
import modelo.Jugador;
import modelo.Tablero;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PartidaVistaTest {

    @Test
    void testInicializarPartidaMuestraMensajeBienvenida() {
        // Simular la entrada del usuario
        String input = "Juan\nsalir\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capturar la salida
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Configurar jugador y tablero
        Jugador jugador = new Jugador("Temporal");
        Tablero tablero = new Tablero(5, 5);

        // Ejecutar la vista
        PartidaVista vista = new PartidaVista();
        vista.inicializarPartida(jugador, tablero);

        // Verificar la salida
        String output = outputStream.toString();
        assertTrue(output.contains("Ingrese su nombre:"));
        assertTrue(output.contains("¡Bienvenido, Juan! Comencemos la partida."));
        assertTrue(output.contains("Partida finalizada. Gracias por jugar, Juan."));
    }

    @Test
    void testEntradaInvalidaMuestraError() {
        // Simular entrada inválida
        String input = "Juan\nFF\nsalir\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capturar la salida
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Configurar jugador y tablero
        Jugador jugador = new Jugador("Juan");
        Tablero tablero = new Tablero(5, 5);

        // Ejecutar la vista
        PartidaVista vista = new PartidaVista();
        vista.inicializarPartida(jugador, tablero);

        // Verificar la salida
        String output = outputStream.toString();
        assertTrue(output.contains("Entrada inválida. Ingresa una coordenada válida, como A1."));
    }
}
