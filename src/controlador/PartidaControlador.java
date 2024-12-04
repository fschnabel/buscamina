//Controlador

package controlador;

import modelo.Partida;
import modelo.Tablero;
import modelo.Jugador;

import java.util.Scanner;

public class PartidaControlador {
    private Partida partida;
    private Scanner scanner;

    public PartidaControlador(String nombreJugador, int filas, int columnas, int minas) {
        Jugador jugador = new Jugador(nombreJugador);
        Tablero tablero = new Tablero(filas, columnas);
        tablero.colocarMinas(minas);
        tablero.asignarNumeros();
        this.partida = new Partida(jugador, tablero);
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        System.out.println("¡Bienvenido al Buscaminas, " + partida.getJugador().getNombre() + "!");
        while (partida.isEnProgreso()) {
            mostrarTablero();
            manejarTurno();
        }
        finalizarJuego();
    }

    private void mostrarTablero() {
        System.out.println("\nEstado actual del tablero:");
        partida.getTablero().imprimirTablero();
    }

    private void manejarTurno() {
        try {
            System.out.println("Ingresa la fila y columna para seleccionar una casilla (ejemplo: 1 2):");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();

            if (!partida.getTablero().seleccionarCasilla(fila, columna)) {
                System.out.println("¡BOOM! Has seleccionado una mina.");
                partida.finalizarPartida();
            } else if (partida.getTablero().juegoGanado()) {
                System.out.println("¡Felicidades! Has revelado todas las casillas sin minas.");
                partida.finalizarPartida();
            }
        } catch (Exception e) {
            System.out.println("Entrada no válida. Intenta de nuevo.");
            scanner.nextLine(); // Limpia el buffer
        }
    }

    private void finalizarJuego() {
        if (partida.getTablero().juegoGanado()) {
            System.out.println("¡Ganaste, " + partida.getJugador().getNombre() + "! Puntuación final: " + partida.getJugador().getPuntuacion());
        } else {
            System.out.println("Fin del juego. Gracias por jugar, " + partida.getJugador().getNombre() + ".");
        }
        mostrarTableroFinal();
    }

    private void mostrarTableroFinal() {
        System.out.println("\nTablero final:");
        partida.getTablero().imprimirTablero();
    }
}
