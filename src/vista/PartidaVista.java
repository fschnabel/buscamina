package vista;

import java.util.Scanner;

import controlador.PartidaControlador;
import excepciones.PartidaFinalizadaException;
import modelo.Jugador;
import modelo.Tablero;

/**
 * Representa la vista de una partida en el juego de Buscaminas. Maneja la
 * interacción con el usuario, incluyendo la entrada y salida en la consola.
 */
public class PartidaVista {

	public String mostrarMenu() {
		Scanner scanner = new Scanner(System.in);
		boolean ejecutando = true;

		System.out.println("\n|---- Buscaminas ----|");
		System.out.println("1. Crear nueva partida");
		System.out.println("2. Ver puntuación");
		System.out.println("3. Salir");
		System.out.print("Seleccione una opción: ");
		return scanner.nextLine();

	}

	/**
	 * Inicializa la partida interactuando con el jugador y mostrando el tablero.
	 * Permite al jugador ingresar coordenadas para jugar hasta que la partida
	 * termine.
	 *
	 * @param jugador el jugador que participa en la partida.
	 * @param tablero el tablero de la partida.
	 */
	public void inicializarPartida(Jugador jugador, Tablero tablero) {
		Scanner scanner = new Scanner(System.in);

		// Configurar el tablero
		tablero.colocarMinas(10);
		tablero.asignarNumeros();

		// Pedir el nombre del jugador
		System.out.println("Ingrese su nombre: ");
		String nombreJugador = scanner.nextLine();
		jugador = new Jugador(nombreJugador);

		System.out.println("¡Bienvenido, " + jugador.getNombre() + "! Comencemos la partida.");
		boolean partidaEnCurso = true;

		tablero.mostrarTablero(partidaEnCurso);
		while (partidaEnCurso) {

			System.out.println("Ingrese una coordenada (ejemplo: A1) o escriba 'salir' para finalizar: ");
			String entrada = scanner.nextLine();

			if (entrada.equalsIgnoreCase("salir")) {
				partidaEnCurso = false;
				System.out.println("Partida finalizada. Gracias por jugar, " + jugador.getNombre() + ".");
			} else {
				try {
					// Convertir la entrada en coordenadas del tablero
					int fila = entrada.toUpperCase().charAt(0) - 'A';
					int columna = Integer.parseInt(entrada.substring(1)) - 1;

					// Verificar si las coordenadas son válidas
					if (fila >= 0 && fila < tablero.getFilas() && columna >= 0 && columna < tablero.getColumnas()) {
						tablero.seleccionarCasilla(fila, columna);
					} else {
						System.out.println("La coordenada está fuera del tablero. Intenta otra vez.");
					}
					if (tablero.juegoGanado()) {
						partidaEnCurso = false;
						System.out.println("Gano la partida");
					}
				} catch (PartidaFinalizadaException e) {
					System.out.println("Perdio la partida");
					partidaEnCurso = false;
				} catch (Exception e) {
					// Manejar entradas inválidas
					System.out.println("Entrada inválida. Ingresa una coordenada válida, como A1.");
				} finally {
					tablero.mostrarTablero(partidaEnCurso);
				}
			}
		}

		// Cerrar el escáner

	}
}
