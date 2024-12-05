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

        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("\n|---- Buscaminas ----|");
            System.out.println("1. Crear nueva partida");
            System.out.println("2. Ver puntuación");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
               
                    controlador.inicializarPartida();
                    break;
                case "2":
                 
                    System.out.println("Tu puntuación es: ");
                    break;
                case "3":
                    
                    ejecutando = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
