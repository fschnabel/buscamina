package modelo;

import excepciones.PartidaFinalizadaException;

/**
 * Representa un casillero que contiene una mina en el juego de Buscaminas.
 * Extiende la funcionalidad de la clase {@link CasilleroVacio}.
 * Al ser revelado, lanza una excepción para finalizar la partida.
 */
public class CasilleroMina extends CasilleroVacio {

    /**
     * Constructor de la clase CasilleroMina.
     *
     * @param fila    la fila en la que se encuentra el casillero con mina.
     * @param columna la columna en la que se encuentra el casillero con mina.
     */
    public CasilleroMina(int fila, int columna) {
        super(fila, columna); // Llama al constructor de la clase Casillero
        setTipo("mina"); // Configura el tipo como "mina"
    }

    /**
     * Indica que la mina ha explotado.
     *
     * @return true siempre que se llame al método.
     */
    public boolean explotar() {
        return true;
    }

    /**
     * Revela el casillero y lanza una excepción para finalizar la partida.
     * 
     * @throws PartidaFinalizadaException cuando se revela un casillero con mina.
     */
    @Override
    public boolean revelar() {
        super.revelar();
        throw new PartidaFinalizadaException("Juego Terminado");
    }

    /**
     * Obtiene el valor representativo del casillero con mina.
     *
     * @return un String que representa una mina ("* ").
     */
    @Override
    public String obtenerValor() {
        return "* ";
    }
}
