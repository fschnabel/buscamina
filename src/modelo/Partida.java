package modelo;

public class Partida {
    private Jugador jugador;
    private Tablero tablero;
    private boolean enProgreso;

    public Partida(Jugador jugador, Tablero tablero) {
        this.jugador = jugador;
        this.tablero = tablero;
        this.enProgreso = true;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public boolean isEnProgreso() {
        return enProgreso;
    }

    public void finalizarPartida() {
        this.enProgreso = false;
    }
}
