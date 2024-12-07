package modelo;

import utils.Colores;

/**
 * Representa el tablero del juego de Buscaminas. Gestiona la disposición de
 * casilleros, asignación de minas, números, y estado del juego.
 */
public class Tablero {
	private int filas;
	private int columnas;
	private Casillero[][] casilleros;
	private int ultimaFila;
	private int ultimaColumna;
	private static final String CASILLA_OCULTA = ". ";

	/**
	 * Constructor de la clase Tablero.
	 *
	 * @param filas    la cantidad de filas del tablero.
	 * @param columnas la cantidad de columnas del tablero.
	 */
	public Tablero(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.casilleros = new Casillero[filas][columnas];
		inicializarCasilleros();
	}

	/**
	 * Inicializa todos los casilleros como vacíos.
	 */
	private void inicializarCasilleros() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				casilleros[i][j] = new CasilleroVacio(i, j); // Inicializa con CasilleroVacio.
			}
		}
	}

	/**
	 * Obtiene un casillero específico del tablero.
	 *
	 * @param fila    la fila del casillero.
	 * @param columna la columna del casillero.
	 * @return el casillero en la posición especificada.
	 */
	public Casillero getCasillero(int fila, int columna) {
		return casilleros[fila][columna];
	}

	/**
	 * Obtiene el número de filas del tablero.
	 *
	 * @return la cantidad de filas.
	 */
	public int getFilas() {
		return filas;
	}

	/**
	 * Obtiene el número de columnas del tablero.
	 *
	 * @return la cantidad de columnas.
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * Obtiene todos los casilleros del tablero.
	 *
	 * @return la matriz de casilleros.
	 */
	public Casillero[][] getCasilleros() {
		return casilleros;
	}

	/**
	 * Coloca un número especificado de minas aleatoriamente en el tablero.
	 *
	 * @param cantidadDeMinas la cantidad de minas a colocar.
	 */
	public void colocarMinas(int cantidadDeMinas) {
		int minasColocadas = 0;

		while (minasColocadas < cantidadDeMinas) {
			int fila = (int) (Math.random() * filas);
			int columna = (int) (Math.random() * columnas);

			if (!(casilleros[fila][columna] instanceof CasilleroMina)) {
				casilleros[fila][columna] = new CasilleroMina(fila, columna);
				minasColocadas++;
			}
		}
	}

	/**
	 * Asigna números a los casilleros indicando la cantidad de minas adyacentes.
	 */
	public void asignarNumeros() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (casilleros[i][j] instanceof CasilleroMina) {
					incrementarNumerosAlrededor(i, j);
				}
			}
		}
	}

	/**
	 * Incrementa el valor de los casilleros numéricos alrededor de una mina.
	 *
	 * @param fila    la fila de la mina.
	 * @param columna la columna de la mina.
	 */
	private void incrementarNumerosAlrededor(int fila, int columna) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int nuevaFila = fila + i;
				int nuevaColumna = columna + j;

				if (esCoordenadaValida(nuevaFila, nuevaColumna)) {
					Casillero casilleroActual = casilleros[nuevaFila][nuevaColumna];

					if (casilleroActual instanceof CasilleroNumero) {
						CasilleroNumero casilleroNumero = (CasilleroNumero) casilleroActual;
						casilleroNumero.setValor(casilleroNumero.getValor() + 1);
					} else if (!(casilleroActual instanceof CasilleroMina)) {
						casilleros[nuevaFila][nuevaColumna] = new CasilleroNumero(nuevaFila, nuevaColumna, 1);
					}
				}
			}
		}
	}

	/**
	 * Verifica si una coordenada es válida dentro del tablero.
	 *
	 * @param fila    la fila a verificar.
	 * @param columna la columna a verificar.
	 * @return true si la coordenada es válida, false en caso contrario.
	 */
	private boolean esCoordenadaValida(int fila, int columna) {
		return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
	}

	/**
	 * Revela un casillero en la posición especificada.
	 * Si el casillero es vacío, revela casilleros adyacentes recursivamente.
	 *
	 * @param fila    la fila del casillero.
	 * @param columna la columna del casillero.
	 */	
	public void seleccionarCasilla(int fila, int columna) {
		ultimaFila = fila;
		ultimaColumna = columna;
		if (casilleros[fila][columna].revelar()) {
			int filaAntes = fila > 0 ? fila - 1 : fila;
			int filaDespues = fila < casilleros.length - 1 ? fila + 1 : fila;
			int columnaAntes = columna > 0 ? columna - 1 : columna;
			int columnaDespues = columna < casilleros[fila].length - 1 ? columna + 1 : columna;
			if (columnaAntes != columna)
				seleccionarCasilla(fila, columnaAntes);
			if (columnaDespues != columna)
				seleccionarCasilla(fila, columnaDespues);
			if (filaAntes != fila)
				seleccionarCasilla(filaAntes, columna);
			if (filaDespues != fila)
				seleccionarCasilla(filaDespues, columna);
		}
	}

	/**
	 * Verifica si el jugador ha ganado la partida.
	 *
	 * @return true si todas las casillas seguras han sido reveladas, false en caso
	 *         contrario.
	 */
	public boolean juegoGanado() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				Casillero casillero = casilleros[i][j];
				if (!(casillero instanceof CasilleroMina) && !casillero.isRevelado()) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Muestra el tablero en la consola.
	 *
	 * @param partidaEnCurso true si la partida aún está en progreso; false si ha terminado.
	 * Si la partida terminó y el jugador pierde, el casillero que causó la derrota se resalta en rojo.
	 */	
	public void mostrarTablero(boolean partidaEnCurso) {
		System.out.print("  ");
		for (int col = 1; col <= columnas; col++) {
			System.out.print(col + " ");
		}
		System.out.println();

		for (int fila = 0; fila < filas; fila++) {
			System.out.print((char) ('A' + fila) + " ");
			for (int col = 0; col < columnas; col++) {
				Casillero casillero = casilleros[fila][col];
				if (partidaEnCurso) {
					if (casillero.isRevelado()) {
						System.out.print(casillero.obtenerValor());
					} else {
						System.out.print(CASILLA_OCULTA);
					}
				} else {
					if (fila == ultimaFila && col == ultimaColumna && !juegoGanado()) {
						System.out.print(Colores.Color.ROJO.getCodigo() + casillero.obtenerValor() + Colores.Color.RESET.getCodigo());
					} else {
						System.out.print(casillero.obtenerValor());
					}
				}
			}
			System.out.println();
		}
	}
}
