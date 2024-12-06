package modelo;

/**
 * Representa un casillero en el tablero de un juego de Buscaminas.
 * Un casillero puede ser revelado, marcado, y tener un tipo (mina, número o vacío).
 */
public interface Casillero {
    
 
    /**
     * Indica si el casillero está revelado.
     *
     * @return true si el casillero está revelado, false en caso contrario.
     */
    public boolean isRevelado(); 

    /**
     * Revela el casillero, cambiando su estado a revelado.
     */
    public boolean revelar(); 

    /**
     * Indica si el casillero está marcado.
     *
     * @return true si el casillero está marcado, false en caso contrario.
     */
    public boolean isMarcado(); 

    /**
     * Marca o desmarca el casillero, alternando su estado actual.
     */
    public void marcar();



    /**
     * Obtiene el valor a mostrar del casillero, útil para su representación en el tablero.
     *
     * @return un String que representa el valor del casillero.
     */
    public String obtenerValor(); 
}
