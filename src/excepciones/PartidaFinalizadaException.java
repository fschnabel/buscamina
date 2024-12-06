package excepciones;

/**
 * Excepción personalizada que se lanza cuando la partida ha finalizado.
 * Extiende de RuntimeException para representar errores en tiempo de ejecución.
 */
public class PartidaFinalizadaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor de la clase PartidaFinalizadaException.
     *
     * @param mensaje el mensaje descriptivo de la excepción.
     */
    public PartidaFinalizadaException(String mensaje) {
        super(mensaje);
    }
}
