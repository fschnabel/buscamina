package modelo;

/**
 * Representa a un jugador en el juego de Buscaminas.
 * Cada jugador tiene un nombre, una puntuación acumulada y un tiempo de juego.
 */
public class Jugador {
    private String nombre;
    private int puntuacion;
    private long tiempoDeJuego;

    /**
     * Constructor de la clase Jugador.
     *
     * @param nombre el nombre del jugador. No puede ser nulo ni vacío.
     * @throws IllegalArgumentException si el nombre es nulo o vacío.
     */
    public Jugador(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
        this.puntuacion = 0;
        this.tiempoDeJuego = 0;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return el nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la puntuación acumulada del jugador.
     *
     * @return la puntuación del jugador.
     */
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     * Incrementa la puntuación del jugador.
     *
     * @param puntos la cantidad de puntos a añadir a la puntuación actual. Debe ser mayor o igual a 0.
     * @throws IllegalArgumentException si los puntos son negativos.
     */
    public void incrementarPuntuacion(int puntos) {
        if (puntos < 0) {
            throw new IllegalArgumentException("No se pueden agregar puntos negativos");
        }
        this.puntuacion += puntos;
    }

    /**
     * Obtiene el tiempo total de juego del jugador.
     *
     * @return el tiempo de juego en milisegundos.
     */
    public long getTiempoDeJuego() {
        return tiempoDeJuego;
    }

    /**
     * Establece el tiempo de juego del jugador.
     *
     * @param tiempoDeJuego el tiempo de juego en milisegundos. Debe ser mayor o igual a 0.
     * @throws IllegalArgumentException si el tiempo de juego es negativo.
     */
    public void setTiempoDeJuego(long tiempoDeJuego) {
        if (tiempoDeJuego < 0) {
            throw new IllegalArgumentException("El tiempo de juego no puede ser negativo");
        }
        this.tiempoDeJuego = tiempoDeJuego;
    }

    /**
     * Devuelve una representación en forma de cadena de texto del jugador.
     *
     * @return un String que contiene el nombre, la puntuación y el tiempo de juego del jugador.
     */
    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                ", tiempoDeJuego=" + tiempoDeJuego +
                '}';
    }
}
