package principal;

import controlador.PartidaControlador;

//Inicializador
public class Main {
    public static void main(String[] args) {
        PartidaControlador controlador = new PartidaControlador("Jugador1", 8, 8, 10);
        controlador.iniciarJuego();
    }
}
