package vista;

import java.util.Scanner;

import excepciones.PartidaFinalizadaException;
import modelo.Casillero;
import modelo.Jugador;
import modelo.Tablero;

public class PartidaVista {
	public void inicializarPartida(Jugador jugador, Tablero tablero) {
		Scanner scanner = new Scanner(System.in);
		tablero.colocarMinas(10);
        tablero.asignarNumeros();

		System.out.println("Ingrese su nombre: ");
		String nombreJugador = scanner.nextLine();
		jugador = new Jugador(nombreJugador);
		System.out.println("¡Bienvenido, " + jugador.getNombre() + "! Comencemos la partida.");
		boolean partidaEnCurso = true;

		while (partidaEnCurso) {
			tablero.mostrarTablero();
			System.out.println("Ingrese una coordenada (ejemplo: A1) o escriba 'salir' para finalizar: ");
			String entrada = scanner.nextLine();

			if (entrada.equalsIgnoreCase("salir")) {
				partidaEnCurso = false;
				System.out.println("Partida finalizada. Gracias por jugar, " + jugador.getNombre() + ".");
			} else {
				try {
					int fila = entrada.toUpperCase().charAt(0) - 'A';
					int columna = Integer.parseInt(entrada.substring(1)) - 1;
					if (fila >= 0 && fila < tablero.getFilas() && columna >= 0 && columna < tablero.getColumnas()) {
						tablero.seleccionarCasilla(fila, columna);
					} else {
						System.out.println("La coordenada está fuera del tablero. Intenta otra vez.");
					}
				} catch(PartidaFinalizadaException e) {
					tablero.mostrarTablero();
					partidaEnCurso = false;
				}
				catch (Exception e) {
					System.out.println("Entrada inválida. Ingresa una coordenada válida, como A1.");
				}
			}
		}

		scanner.close();
	}

	
}
