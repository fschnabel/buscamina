package modelo;

/**
 * Representa un casillero vacío en el juego de Buscaminas.
 * No contiene minas ni números, y no realiza acciones especiales al revelarse.
 */
public class CasilleroVacio extends Casillero {

    /**
     * Constructor de la clase CasilleroVacio.
     *
     * @param fila    la fila en la que se encuentra el casillero vacío.
     * @param columna la columna en la que se encuentra el casillero vacío.
     */
    public CasilleroVacio(int fila, int columna) {
        super(fila, columna); // Llama al constructor de la clase base Casillero
        setTipo("vacío"); // Configura el tipo como "vacío"
    }
}
