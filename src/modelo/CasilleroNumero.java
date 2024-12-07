package modelo;

import java.util.ArrayList;

import utils.Colores;
import utils.Colores.Color;

/**
 * Representa un casillero numérico en el juego de Buscaminas. Indica la
 * cantidad de minas cercanas en un casillero.
 */
public class CasilleroNumero extends CasilleroVacio {
	private int valor;

	/**
	 * Constructor de la clase CasilleroNumero.
	 *
	 * @param fila    la fila en la que se encuentra el casillero.
	 * @param columna la columna en la que se encuentra el casillero.
	 * @param valor   el número de minas adyacentes al casillero.
	 */
	public CasilleroNumero(int fila, int columna, int valor) {
		super(fila, columna); // Llama al constructor de la clase base Casillero
		this.valor = valor;
		setTipo("numero"); // Configura el tipo como "numero"
	}

	/**
	 * Obtiene el valor numérico del casillero.
	 *
	 * @return el número de minas adyacentes al casillero.
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Establece el valor numérico del casillero.
	 *
	 * @param valor el número de minas adyacentes que se desea asignar al casillero.
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * Obtiene el valor representativo del casillero numérico.
	 *
	 * @return Un String que representa el número de minas adyacentes si está
	 *         revelado; "." en caso contrario.
	 */
	@Override
	public String obtenerValor() {
		if (this.revelado) {
			Color color = Colores.Color.RESET;
			switch (valor) {
			case 1 -> color = Colores.Color.VERDE;
			case 2 -> color = Colores.Color.AZUL;
			case 3 -> color = Colores.Color.AMARILLO;
			case 4 -> color = Colores.Color.MAGENTA;

			}
			return color.getCodigo() + String.valueOf(valor) + " " + Colores.Color.RESET.getCodigo();
		} else {
			return ". ";
		}
	}

	/**
	 * Revela el casillero, cambiando su estado a revelado.
	 *
	 * @return true si el casillero fue revelado por primera vez, false si ya estaba
	 *         revelado.
	 */
	public boolean revelar() {
		super.revelar();
		return false;
	}
}
