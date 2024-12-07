package vista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Jugador;

/**
 * Clase para gestionar la lectura y escritura de datos relacionados con jugadores en un archivo de texto.
 * Los datos incluyen el nombre del jugador y el tiempo de juego.
 */
public class ArchivoVista {
	
	private static final String RUTA_ARCHIVO = "Puntaje.txt";

	/**
     * Lee y muestra en consola las puntuaciones almacenadas en el archivo "Puntaje.txt".
     * Si el archivo no existe o ocurre un error, se muestra un mensaje indicando que no hay puntuaciones disponibles.
     */
	public static void leerPuntuacion() {
		try (BufferedReader br = new BufferedReader(new FileReader("Puntaje.txt"))) {

			String linea;

			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			System.out.println("No se consta con puntuación");
		}
	}

	/**
     * Escribe los datos de un jugador en el archivo "Puntaje.txt".
     * Si el archivo no existe, se crea automáticamente.
     * El formato de los datos es:
     * <pre>
     * jugador:<nombre_del_jugador>-------->>>>tiempo:<tiempo_de_juego>
     * </pre>
     *
     * @param jugador Objeto de la clase Jugador que contiene el nombre y el tiempo de juego.
     */
	public static void escribirDatos(Jugador jugador) {
		StringBuilder registros = new StringBuilder();

		registros.append("jugador:");
		registros.append(jugador.getNombre());
		registros.append("-------->>>>tiempo:");
		registros.append(jugador.getTiempoDeJuego());
		registros.append(" segundos\n");
		// Crea el archivo y escribe el contenido.
		try (FileWriter escritor = new FileWriter("Puntaje.txt")) {
			escritor.write(registros.toString());

		} catch (IOException e) {
			System.out.println("Ocurrió un error al crear/escribir el archivo.");
			e.printStackTrace();
		}
	}
}
