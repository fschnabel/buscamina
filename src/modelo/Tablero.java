package modelo;

public class Tablero {
    private int filas;
    private int columnas;
    private Casillero[][] casilleros;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.casilleros = new Casillero[filas][columnas];
        inicializarCasilleros();
    }

    private void inicializarCasilleros() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casilleros[i][j] = new CasilleroVacio(i, j); // Inicializamos con CasilleroVacio
            }
        }
    }

    public Casillero getCasillero(int fila, int columna) {
        return casilleros[fila][columna];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public Casillero[][] getCasilleros() {
        return casilleros;
    }

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

    public void asignarNumeros() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (casilleros[i][j] instanceof CasilleroMina) {
                    incrementarNumerosAlrededor(i, j);
                }
            }
        }
    }

    private void incrementarNumerosAlrededor(int fila, int columna) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;

                if (esCoordenadaValida(nuevaFila, nuevaColumna)) {
                    Casillero casilleroActual = casilleros[nuevaFila][nuevaColumna];

                    if (casilleroActual instanceof CasilleroVacio) {
                        // Convertir CasilleroVacio en CasilleroNumero con valor 1
                        casilleros[nuevaFila][nuevaColumna] = new CasilleroNumero(nuevaFila, nuevaColumna, 1);
                    } else if (casilleroActual instanceof CasilleroNumero) {
                        // Incrementar el valor si ya es un CasilleroNumero
                        CasilleroNumero casilleroNumero = (CasilleroNumero) casilleroActual;
                        int nuevoValor = casilleroNumero.getValor() + 1;
                        casilleroNumero.setValor(nuevoValor);
                    }
                }
            }
        }
    }

    private boolean esCoordenadaValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    // Método para seleccionar casilla
    public void seleccionarCasilla(int fila, int columna) {
    	casilleros[fila][columna].revelar();
    	
 
    }

    // Método para verificar si el jugador ha ganado
    public boolean juegoGanado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Casillero casillero = casilleros[i][j];
                if (casillero instanceof CasilleroVacio || casillero instanceof CasilleroNumero) {
                    if (!casillero.isRevelado()) {
                        return false; // Si alguna casilla segura no ha sido revelada, el juego no ha terminado
                    }
                }
            }
        }
        return true; // Si todas las casillas seguras han sido reveladas, el jugador gana
    }

  
    
    public void mostrarTablero() {
    	System.out.print("  ");
		for (int col = 1; col <= columnas; col++) {
			System.out.print(col + " ");
		}
		System.out.println();

		for (int fila = 0; fila < filas; fila++) {
			System.out.print((char) ('A' + fila) + " ");
			for (int col = 0; col < columnas; col++) {
				Casillero casillero = casilleros[fila][col];
				if (casillero.isRevelado()) {
					System.out.print(casillero.obtenerValor());
				} else {

					System.out.print(". ");
				}
			}
			System.out.println();
		}
    }
}
