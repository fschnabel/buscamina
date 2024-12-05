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

    // Se añade el setter para permitir modificar el valor
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    @Override
    public String obtenerValor() {
    	return String.valueOf(valor) + " ";
    }
}
