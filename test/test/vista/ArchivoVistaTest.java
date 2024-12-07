package test.vista;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import modelo.Jugador;
import vista.ArchivoVista;

import static org.junit.jupiter.api.Assertions.*;

class ArchivoVistaTest {

    private static final String TEST_FILE = "Puntaje.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Asegurarse de que el archivo de prueba esté limpio antes de cada prueba.
        Files.deleteIfExists(Path.of(TEST_FILE));
    }

    @AfterEach
    void tearDown() throws IOException {
        // Limpiar después de cada prueba.
        Files.deleteIfExists(Path.of(TEST_FILE));
    }

    @Test
    void testEscribirDatos() {
        // Crear un objeto Jugador para la prueba.
        Jugador jugador = new Jugador("Jugador1");
        jugador.setTiempoDeJuego(120);

        // Llamar al método para escribir los datos.
        ArchivoVista.escribirDatos(jugador);

        // Verificar que el archivo se creó y contiene los datos esperados.
        try (BufferedReader br = new BufferedReader(new FileReader(TEST_FILE))) {
            String contenido = br.readLine();
            assertEquals("jugador:Jugador1-------->>>>tiempo:120", contenido);
        } catch (IOException e) {
            fail("Error al leer el archivo de prueba.");
        }
    }

    @Test
    void testLeerPuntuacionArchivoExistente() {
        // Crear un archivo de prueba con datos simulados.
        String datos = "jugador:Jugador1-------->>>>tiempo:120\n";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEST_FILE))) {
            bw.write(datos);
        } catch (IOException e) {
            fail("Error al preparar el archivo de prueba.");
        }

        // Capturar la salida de consola.
        ByteArrayOutputStream salidaConsola = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salidaConsola));

        // Llamar al método para leer los datos.
        ArchivoVista.leerPuntuacion();

        // Restaurar la salida estándar.
        System.setOut(System.out);

        // Verificar que se imprimió el contenido esperado.
        assertTrue(salidaConsola.toString().contains("jugador:Jugador1-------->>>>tiempo:120"));
    }

    @Test
    void testLeerPuntuacionArchivoInexistente() {
        // Capturar la salida de consola.
        ByteArrayOutputStream salidaConsola = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salidaConsola));

        // Llamar al método para leer los datos (sin archivo).
        ArchivoVista.leerPuntuacion();

        // Restaurar la salida estándar.
        System.setOut(System.out);

        // Verificar el mensaje esperado.
        assertTrue(salidaConsola.toString().contains("No se consta con puntuación"));
    }
}

