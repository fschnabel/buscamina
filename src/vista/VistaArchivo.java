package vista;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Jugador;

/**
 * Clase para leer y escribir datos de archivos que contienen información de contenidos audiovisuales.
 */
public class VistaArchivo {

    /**
     * Lee datos desde un archivo y los transforma en una lista de entidades del tipo especificado.
     *
     * @param <T>          Tipo genérico que extiende ContenidoAudiovisual.
     * @param tipoContenido Clase del tipo de contenido a leer.
     * @param ruta         Ruta del archivo a leer.
     * @param tipoArchivo  Implementación de TipoArchivo para manejar el formato del archivo.
     * @return Lista de entidades del tipo especificado, o `null` si ocurre un error.
     */
    public static void leerPuntuacion ()
                                                             {
        try (BufferedReader br = new BufferedReader(new FileReader("Puntaje.txt"))) {
           
            String linea;
    
            while ((linea = br.readLine()) != null) {
            System.out.println(linea);
            }
          
        } catch (IOException e) {
           System.out.println(e.getMessage());
        }
    }

    /**
     * Escribe una lista de entidades en un archivo.
     *
     * @param datos       Lista de entidades a escribir.
     * @param ruta        Ruta del archivo a escribir.
     * @param tipoArchivo Implementación de TipoArchivo para manejar el formato del archivo.
     */
    public static void  escribirDatos(Jugador jugador) {
        StringBuilder registros = new StringBuilder();

       
        registros.append("jugador:");
        registros.append(jugador.getNombre());
        registros.append("-------->>>>tiempo:");
        registros.append(jugador.getTiempoDeJuego());
        registros.append("\n");
        // Crea el archivo y escribe el contenido.
        try (FileWriter escritor = new FileWriter("Puntaje.txt")) {
            escritor.write(registros.toString());
            
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear/escribir el archivo.");
            e.printStackTrace();
        }
    }
}
