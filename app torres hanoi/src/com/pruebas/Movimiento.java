package com.pruebas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Movimiento extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("hola");
	}
}
