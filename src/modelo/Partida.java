package modelo;

/**
 * Representa una partida del juego de Buscaminas.
 * Contiene información sobre el jugador, el tablero y el estado de la partida.
 */
public class Partida {
    private Jugador jugador;
    private Tablero tablero;
    private boolean enProgreso;

    /**
     * Constructor de la clase Partida.
     *
     * @param jugador el jugador que participa en la partida.
     * @param tablero el tablero asociado a la partida.
     */
    public Partida(Jugador jugador, Tablero tablero) {
        this.jugador = jugador;
        this.tablero = tablero;
        this.enProgreso = true; // La partida inicia en progreso.
    }

    /**
     * Obtiene el jugador asociado a la partida.
     *
     * @return el jugador que está participando en la partida.
     */
    public Jugador getJugador() {
        return jugador;
    }

    /**
     * Obtiene el tablero de la partida.
     *
     * @return el tablero asociado a la partida.
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Verifica si la partida está en progreso.
     *
     * @return true si la partida está en progreso, false si ha terminado.
     */
    public boolean isEnProgreso() {
        return enProgreso;
    }

    /**
     * Finaliza la partida, cambiando su estado a no en progreso.
     */
    public void finalizarPartida() {
        this.enProgreso = false;
    }
}
