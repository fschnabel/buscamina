package test.modelo;

import modelo.Tablero;
import modelo.CasilleroMina;
import org.junit.jupiter.api.Test;

import excepciones.PartidaFinalizadaException;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {

	@Test
	void testInicializarCasilleros() {
		Tablero tablero = new Tablero(5, 5);
		assertEquals(5, tablero.getFilas());
		assertEquals(5, tablero.getColumnas());
		assertNotNull(tablero.getCasillero(0, 0));
	}

	@Test
	void testColocarMinas() {
		Tablero tablero = new Tablero(5, 5);
		tablero.colocarMinas(3);
		int minas = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (tablero.getCasillero(i, j) instanceof CasilleroMina) {
					minas++;
				}
			}
		}
		assertEquals(3, minas);
	}

	@Test
	void testJuegoGanado() {
		Tablero tablero = new Tablero(10, 10);
		tablero.colocarMinas(10);
		tablero.asignarNumeros();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (!(tablero.getCasilleros()[i][j] instanceof CasilleroMina)) {
					tablero.seleccionarCasilla(i, j);
				}
			}
		}
		assertTrue(tablero.juegoGanado());
	}

	@Test
	void testJuegoPerdido() {
		assertThrows(PartidaFinalizadaException.class, () -> {
			Tablero tablero = new Tablero(10, 10);
			tablero.colocarMinas(10);
			tablero.asignarNumeros();
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if ((tablero.getCasilleros()[i][j] instanceof CasilleroMina)) {
						tablero.seleccionarCasilla(i, j);
					}
				}
			}
		});
	}

}
