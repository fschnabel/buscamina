// Controlador

package controlador;

import modelo.Tablero;
import modelo.Jugador;
import vista.PartidaVista;
import vista.ArchivoVista;

import java.util.Scanner;

/**
 * Controlador para gestionar la lógica de una partida en el juego de
 * Buscaminas. Conecta la vista con los modelos de datos para gestionar el flujo
 * del juego.
 */
public class PartidaControlador {
	private Tablero tablero;
	private Jugador jugador;
	private PartidaVista partidaVista;

	/**
	 * Constructor que inicializa el controlador con un jugador, un tablero y una
	 * vista.
	 *
	 * @param jugador      el jugador que participa en la partida.
	 * @param tablero      el tablero del juego.
	 * @param partidaVista la vista asociada para la interacción con el jugador.
	 */
	public PartidaControlador(Jugador jugador, Tablero tablero, PartidaVista partidaVista) {
		this.tablero = tablero;
		this.jugador = jugador;
		this.partidaVista = partidaVista;
	}

	/**
	 * Constructor que inicializa el controlador creando un jugador y un tablero con
	 * los parámetros especificados. También genera las minas y asigna números a los
	 * casilleros.
	 *
	 * @param nombreJugador el nombre del jugador.
	 * @param filas         el número de filas del tablero.
	 * @param columnas      el número de columnas del tablero.
	 * @param minas         la cantidad de minas a colocar en el tablero.
	 */
	public PartidaControlador(String nombreJugador, int filas, int columnas, int minas) {
		Jugador jugador = new Jugador(nombreJugador);
		Tablero tablero = new Tablero(filas, columnas);
		tablero.colocarMinas(minas);
		tablero.asignarNumeros();
	}

	/**
	 * Inicializa la partida utilizando la vista para mostrar los elementos
	 * iniciales al jugador.
	 */
	public void inicializarPartida() {
		partidaVista.inicializarPartida(jugador, tablero);
	}

	public void mostarMenu() {
		boolean ejecutando = true;
		while (ejecutando) {
			tablero = new Tablero(8, 10);

			String opcion = partidaVista.mostrarMenu();

			switch (opcion) {
			case "1" -> inicializarPartida();

			case "2" -> ArchivoVista.leerPuntuacion();

			case "3" -> ejecutando = false;
			default -> System.out.println("Opción inválida. Intente nuevamente.");
			}
		}
		System.out.println("¡Hasta luego!");

	}
}
