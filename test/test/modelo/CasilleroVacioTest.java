package test.modelo;

import modelo.CasilleroVacio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CasilleroVacioTest {

    @Test
    void testInicializacion() {
        CasilleroVacio vacio = new CasilleroVacio(0, 0);
        assertEquals("vacío", vacio.getTipo());
    }
}
