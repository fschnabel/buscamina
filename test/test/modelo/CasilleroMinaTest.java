package test.modelo;

import modelo.CasilleroMina;
import excepciones.PartidaFinalizadaException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CasilleroMinaTest {

    @Test
    void testExplotar() {
        CasilleroMina mina = new CasilleroMina(0, 0);
        assertTrue(mina.explotar());
    }

    @Test
    void testRevelarLanzaExcepcion() {
        CasilleroMina mina = new CasilleroMina(0, 0);
        assertThrows(PartidaFinalizadaException.class, mina::revelar);
    }
}
