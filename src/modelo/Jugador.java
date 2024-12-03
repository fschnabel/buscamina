package modelo;

public class Jugador {
    private String nombre;
    private int puntuacion;
    private long tiempoDeJuego;

    public Jugador(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
        this.puntuacion = 0;
        this.tiempoDeJuego = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void incrementarPuntuacion(int puntos) {
        if (puntos < 0) {
            throw new IllegalArgumentException("No se pueden agregar puntos negativos");
        }
        this.puntuacion += puntos;
    }

    public long getTiempoDeJuego() {
        return tiempoDeJuego;
    }

    public void setTiempoDeJuego(long tiempoDeJuego) {
        if (tiempoDeJuego < 0) {
            throw new IllegalArgumentException("El tiempo de juego no puede ser negativo");
        }
        this.tiempoDeJuego = tiempoDeJuego;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                ", tiempoDeJuego=" + tiempoDeJuego +
                '}';
    }
}
