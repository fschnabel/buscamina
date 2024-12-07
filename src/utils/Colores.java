package utils;

public class Colores {
	public enum Color {

		RESET("\u001B[0m"), ROJO("\u001B[31m"), VERDE("\u001B[32m"), AZUL("\u001B[34m"), AMARILLO("\u001B[33m"),
		MAGENTA("\u001B[35m");

		private final String codigo;

		// Constructor
		Color(String codigo) {
			this.codigo = codigo;
		}

		// Método para obtener el código del color
		public String getCodigo() {
			return codigo;
		}
	}
}
