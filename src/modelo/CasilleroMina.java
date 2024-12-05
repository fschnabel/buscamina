package modelo;

import excepciones.PartidaFinalizadaException;

public class CasilleroMina extends Casillero {
    public CasilleroMina(int fila, int columna) {
    	super(fila, columna); // Llama al constructor de la clase Casillero
        setTipo("mina"); // Configura el tipo como "mina"
    }

    public boolean explotar() {
        // Este método simplemente indica que la mina ha explotado
        return true;
    }
    
    @Override
    public void revelar() {
    	super.revelar();
    	throw new PartidaFinalizadaException("Juego Terminado");
    }
    
    @Override
    public String obtenerValor() {
    	return "* ";
    }
}
