package test.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import modelo.Casillero;

class CasilleroTest {

    @Test
    void testInicializacion() {
        Casillero casillero = new Casillero(0, 0);
        assertFalse(casillero.isRevelado());
        assertFalse(casillero.isMarcado());
        assertEquals("vacío", casillero.getTipo());
    }

    @Test
    void testRevelar() {
        Casillero casillero = new Casillero(0, 0);
        casillero.revelar();
        assertTrue(casillero.isRevelado());
    }

    @Test
    void testMarcar() {
        Casillero casillero = new Casillero(0, 0);
        casillero.marcar();
        assertTrue(casillero.isMarcado());
        casillero.marcar();
        assertFalse(casillero.isMarcado());
    }
}
