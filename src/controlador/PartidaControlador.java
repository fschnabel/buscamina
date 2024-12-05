//Controlador

package controlador;

import modelo.Partida;
import modelo.Tablero;
import modelo.Jugador;
import vista.PartidaVista;

import java.util.Scanner;

public class PartidaControlador {
	private Partida partida;
	private Scanner scanner;
	private Tablero tablero;
	private Jugador jugador;
	private PartidaVista partidaVista;

	public PartidaControlador(Jugador jugador, Tablero tablero, PartidaVista partidaVista) {
		this.tablero = tablero;
		this.jugador = jugador;
		this.partidaVista = partidaVista;
	}

	public PartidaControlador(String nombreJugador, int filas, int columnas, int minas) {
		Jugador jugador = new Jugador(nombreJugador);
		Tablero tablero = new Tablero(filas, columnas);
		tablero.colocarMinas(minas);
		tablero.asignarNumeros();
		this.partida = new Partida(jugador, tablero);
		this.scanner = new Scanner(System.in);
	}

	public void inicializarPartida() {
		partidaVista.inicializarPartida(jugador, tablero);

	}

}
