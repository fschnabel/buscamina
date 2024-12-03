package modelo;

public class CasilleroNumero extends Casillero {
    private int valor;

    public CasilleroNumero(int fila, int columna, int valor) {
        super(fila, columna);
        this.valor = valor;
        setTipo("numero");
    }

    public int getValor() {
        return valor;
    }
}
