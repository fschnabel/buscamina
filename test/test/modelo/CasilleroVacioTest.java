package test.modelo;

import modelo.Casillero;
import modelo.CasilleroVacio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CasilleroVacioTest {


    @Test
    void testInicializacion() {
    	CasilleroVacio casillero = new CasilleroVacio(0, 0);
        assertFalse(casillero.isRevelado());
        assertFalse(casillero.isMarcado());
        assertEquals("vacío", casillero.getTipo());
    }

    @Test
    void testRevelar() {
    	CasilleroVacio casillero = new CasilleroVacio(0, 0);
        casillero.revelar();
        assertTrue(casillero.isRevelado());
    }

    @Test
    void testMarcar() {
    	CasilleroVacio casillero = new CasilleroVacio(0, 0);
        casillero.marcar();
        assertTrue(casillero.isMarcado());
        casillero.marcar();
        assertFalse(casillero.isMarcado());
    }
}
