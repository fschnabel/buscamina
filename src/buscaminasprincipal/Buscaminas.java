package buscaminasprincipal;

import controlador.PartidaControlador;
import modelo.Jugador;
import modelo.Tablero;
import vista.PartidaVista;

import java.util.Scanner;

public class Buscaminas {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Jugador jugador = new Jugador(" Jugador ");
		Tablero tablero = new Tablero(8, 10);
		PartidaVista vista = new PartidaVista();
		PartidaControlador controlador = new PartidaControlador(jugador, tablero, vista);
		controlador.mostarMenu();
		scanner.close();

	}
}
