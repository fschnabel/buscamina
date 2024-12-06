package test.controlador;

import controlador.PartidaControlador;
import modelo.Jugador;
import modelo.Tablero;
import vista.PartidaVista;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

class PartidaControladorTest {

    @Test
    void testInicializarPartidaSinMockito() {
    	
    	String input = "Juan\nFF\nsalir\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // Crear objetos reales
        Jugador jugador = new Jugador("Juan");
        Tablero tablero = new Tablero(5, 5);
        PartidaVista vista = new PartidaVista();

        // Instanciar el controlador con los objetos reales
        PartidaControlador controlador = new PartidaControlador(jugador, tablero, vista);

        // Ejecutar el método inicializarPartida
        controlador.inicializarPartida();

        // Verificar que no lanza excepciones y se inicializa correctamente
        assertNotNull(controlador); // El controlador no es nulo
        assertEquals("Juan", jugador.getNombre()); // El nombre del jugador es correcto
        assertEquals(5, tablero.getFilas()); // El tablero tiene las filas correctas
    }
}
