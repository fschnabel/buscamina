package modelo;

public class CasilleroMina extends Casillero {
    public CasilleroMina(int fila, int columna) {
    	super(fila, columna); // Llama al constructor de la clase Casillero
        setTipo("mina"); // Configura el tipo como "mina"
    }

    public boolean explotar() {
        // Este método simplemente indica que la mina ha explotado
        return true;
    }
}
