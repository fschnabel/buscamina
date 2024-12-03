package modelo;

public class Casillero {
    private int fila;
    private int columna;
    private boolean revelado;
    private boolean marcado;
    private String tipo; // Puede ser "mina", "numero" o "vacío"

    public Casillero(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.revelado = false;
        this.marcado = false;
        this.tipo = "vacío";
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isRevelado() {
        return revelado;
    }

    public void revelar() {
        this.revelado = true;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void marcar() {
        this.marcado = !marcado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

