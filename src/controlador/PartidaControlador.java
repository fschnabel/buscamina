package controlador;

import modelo.Tablero;
import vista.PartidaVista;
import modelo.Jugador;

public class PartidaControlador {
    private Tablero tablero;
    private Jugador jugador;
    private PartidaVista partidaVista;

    public PartidaControlador(Jugador jugador, Tablero tablero, PartidaVista partidaVista) {
        this.tablero = tablero;
        this.jugador = jugador;
        this.partidaVista = partidaVista;
    }

    public void inicializarPartida() {
        partidaVista.inicializarPartida(jugador, tablero);
    }
}
