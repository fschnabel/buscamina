package modelo;

/**
 * Representa un casillero numérico en el juego de Buscaminas.
 * Indica la cantidad de minas cercanas en un casillero.
 */
public class CasilleroNumero extends Casillero {
    private int valor;

    /**
     * Constructor de la clase CasilleroNumero.
     *
     * @param fila    la fila en la que se encuentra el casillero.
     * @param columna la columna en la que se encuentra el casillero.
     * @param valor   el número de minas adyacentes al casillero.
     */
    public CasilleroNumero(int fila, int columna, int valor) {
        super(fila, columna); // Llama al constructor de la clase base Casillero
        this.valor = valor;
        setTipo("numero"); // Configura el tipo como "numero"
    }

    /**
     * Obtiene el valor numérico del casillero.
     *
     * @return el número de minas adyacentes al casillero.
     */
    public int getValor() {
        return valor;
    }

    /**
     * Establece el valor numérico del casillero.
     *
     * @param valor el número de minas adyacentes que se desea asignar al casillero.
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Obtiene el valor representativo del casillero numérico.
     *
     * @return un String que representa el número de minas adyacentes seguido de un espacio.
     */
    @Override
    public String obtenerValor() {
        return String.valueOf(valor) + " ";
    }
}
