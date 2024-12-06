package modelo;

/**
 * Representa un casillero en el tablero de un juego de Buscaminas.
 * Un casillero puede ser revelado, marcado, y tener un tipo (mina, número o vacío).
 */
public class Casillero {
    private int fila;
    private int columna;
    protected boolean revelado;
    private boolean marcado;
    private String tipo; // Puede ser "mina", "numero" o "vacío"

    /**
     * Constructor de la clase Casillero.
     *
     * @param fila    la fila en la que se encuentra el casillero.
     * @param columna la columna en la que se encuentra el casillero.
     */
    public Casillero(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.revelado = false;
        this.marcado = false;
        this.tipo = "vacío";
    }

    /**
     * Obtiene la fila del casillero.
     *
     * @return la fila del casillero.
     */
    public int getFila() {
        return fila;
    }

    /**
     * Obtiene la columna del casillero.
     *
     * @return la columna del casillero.
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Indica si el casillero está revelado.
     *
     * @return true si el casillero está revelado, false en caso contrario.
     */
    public boolean isRevelado() {
        return revelado;
    }

    /**
     * Revela el casillero, cambiando su estado a revelado.
     */
    public boolean revelar() {
    	if (this.revelado)
    		return false;
        this.revelado = true;
        return true;
    }

    /**
     * Indica si el casillero está marcado.
     *
     * @return true si el casillero está marcado, false en caso contrario.
     */
    public boolean isMarcado() {
        return marcado;
    }

    /**
     * Marca o desmarca el casillero, alternando su estado actual.
     */
    public void marcar() {
        this.marcado = !marcado;
    }

    /**
     * Obtiene el tipo del casillero.
     * Puede ser "mina", "numero" o "vacío".
     *
     * @return el tipo del casillero.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del casillero.
     *
     * @param tipo el tipo del casillero. Debe ser "mina", "numero" o "vacío".
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene el valor a mostrar del casillero, útil para su representación en el tablero.
     *
     * @return un String que representa el valor del casillero.
     */
    public String obtenerValor() {
    	if (this.revelado) {
    		return "  ";
    	}else {
    		return ". ";
    	}
    }
}
