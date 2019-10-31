package com.pruebas;

public class Pieza {
	private int pieza;
	
	public Pieza(int pieza) {
		this.setPieza(pieza);
	}

	public int getPieza() {
		return pieza;
	}

	public void setPieza(int pieza) {
		this.pieza = pieza;
	}

	@Override
	public String toString() {
		return "Pieza [pieza=" + pieza + "]";
	}
}
