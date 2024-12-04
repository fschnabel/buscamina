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
    public boolean seleccionarCasilla(int fila, int columna) {
        Casillero casillero = casilleros[fila][columna];
        
        if (casillero instanceof CasilleroMina) {
            // Si es una mina, el juego termina
            return false;
        } else {
            casillero.revelar();
            return true;
        }
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

    // Método para imprimir el tablero
    public void imprimirTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Casillero casillero = casilleros[i][j];
                
                if (casillero.isRevelado()) {
                    // Si la casilla está revelada, mostramos su tipo
                    if (casillero instanceof CasilleroMina) {
                        System.out.print("* "); // Representa una mina
                    } else if (casillero instanceof CasilleroNumero) {
                        CasilleroNumero casilleroNumero = (CasilleroNumero) casillero;
                        System.out.print(casilleroNumero.getValor() + " "); // Muestra el número alrededor
                    }
                } else {
                    // Si la casilla no está revelada, mostramos un símbolo
                    System.out.print("# "); // Casilla no revelada
                }
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }
}
