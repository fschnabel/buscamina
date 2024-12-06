package test.modelo;

import modelo.Partida;
import modelo.Jugador;
import modelo.Tablero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {

    @Test
    void testInicializarPartida() {
        Jugador jugador = new Jugador("Juan");
        Tablero tablero = new Tablero(5, 5);
        Partida partida = new Partida(jugador, tablero);
        assertTrue(partida.isEnProgreso());
        assertEquals(jugador, partida.getJugador());
    }

    @Test
    void testFinalizarPartida() {
        Jugador jugador = new Jugador("Juan");
        Tablero tablero = new Tablero(5, 5);
        Partida partida = new Partida(jugador, tablero);
        partida.finalizarPartida();
        assertFalse(partida.isEnProgreso());
    }
}
