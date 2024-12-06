package test.modelo;

import modelo.CasilleroNumero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CasilleroNumeroTest {

    @Test
    void testValorInicial() {
        CasilleroNumero numero = new CasilleroNumero(0, 0, 3);
        assertEquals(3, numero.getValor());
    }

    @Test
    void testModificarValor() {
        CasilleroNumero numero = new CasilleroNumero(0, 0, 3);
        numero.setValor(5);
        assertEquals(5, numero.getValor());
    }
}
