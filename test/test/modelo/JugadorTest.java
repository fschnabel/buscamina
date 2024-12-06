package test.modelo;

import modelo.Jugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
    void testInicializacion() {
        Jugador jugador = new Jugador("Juan");
        assertEquals("Juan", jugador.getNombre());
        assertEquals(0, jugador.getPuntuacion());
    }

    @Test
    void testIncrementarPuntuacion() {
        Jugador jugador = new Jugador("Juan");
        jugador.incrementarPuntuacion(10);
        assertEquals(10, jugador.getPuntuacion());
    }

    @Test
    void testTiempoDeJuego() {
        Jugador jugador = new Jugador("Juan");
        jugador.setTiempoDeJuego(5000);
        assertEquals(5000, jugador.getTiempoDeJuego());
    }
}
