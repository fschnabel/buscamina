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
                casilleros[i][j] = new Casillero(i, j);
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
}
