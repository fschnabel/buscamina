package modelo;

public class CasilleroVacio extends Casillero {
    public CasilleroVacio(int fila, int columna) {
        super(fila, columna);
        setTipo("vacío");
    }
}
