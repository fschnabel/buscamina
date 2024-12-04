package vista;

import java.util.Scanner;
import modelo.Casillero;
import modelo.Jugador;
import modelo.Tablero;

public class PartidaVista {
    public void inicializarPartida(Jugador jugador, Tablero tablero) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su nombre: ");
        String nombreJugador = scanner.nextLine();
        jugador = new Jugador(nombreJugador);
        System.out.println("¡Bienvenido, " + jugador.getNombre() + "! Comencemos la partida.");

        tablero = new Tablero(8, 10);
        boolean partidaEnCurso = true;

        while (partidaEnCurso) {
            mostrarTablero(tablero); 
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
                        Casillero casillero = tablero.getCasillero(fila, columna);

                        if (!casillero.isRevelado()) {
                            casillero.revelar();
                            System.out.println("¡Casilla marcada con éxito!");
                        } else {
                            System.out.println("Ya marcaste esta casilla.");
                        }
                    } else {
                        System.out.println("La coordenada está fuera del tablero. Intenta otra vez.");
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Ingresa una coordenada válida, como A1.");
                }
            }
        }

        scanner.close();
    }

    private void mostrarTablero(Tablero tablero) {
        System.out.print("  ");
        for (int col = 1; col <= tablero.getColumnas(); col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int fila = 0; fila < tablero.getFilas(); fila++) {
            System.out.print((char) ('A' + fila) + " ");
            for (int col = 0; col < tablero.getColumnas(); col++) {
                Casillero casillero = tablero.getCasillero(fila, col);
                if (casillero.isRevelado()) {
                   
                    System.out.print("X ");
                } else {
                    
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
