package com.modelo;

import java.awt.Rectangle;

public class Moneda {
	public Rectangle pieza;
	
	public int denominacion;
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 500;
	
	private final int baseWidth = 150;
	private final int baseHeight = 10;
	private final int baseY = HEIGHT - 100;
	private final int b1pX = 0;
	private final int b2pX = 230;
	private final int b3pX = WIDTH - 150;
	
	private final int ap1X = (baseWidth / 2) - 2;
	private final int ap2X = (b2pX + baseWidth / 2) - 2;
	private final int ap3X = (b3pX + baseWidth / 2) - 2;
	
	public int pos1Y = baseY - 10;
	public int pos2Y = baseY - 20;
	public int pos3Y = baseY - 30;
	public int pos4Y = baseY - 40;
	public int pos5Y = baseY - 50;
	public int pos6Y = baseY - 60;
	public int pos7Y = baseY - 70;
	public int pos8Y = baseY - 80;
	
	public Moneda(int denominacion) {
		this.denominacion = denominacion;
		
		switch (denominacion) {
		case 1:
			pieza = new Rectangle(ap1X - ((baseWidth - 15) / 2 - 2), pos1Y, baseWidth - 15, baseHeight);
			break;
			
		case 2:
			pieza = new Rectangle(ap1X - ((baseWidth - 30) / 2 - 2), pos2Y, baseWidth - 30, baseHeight);
			break;
			
		case 3:
			pieza = new Rectangle(ap1X - ((baseWidth - 45) / 2 - 2), pos3Y, baseWidth - 45, baseHeight);
			break;
			
		case 4:
			pieza = new Rectangle(ap1X - ((baseWidth - 60) / 2 - 2), pos4Y, baseWidth - 60, baseHeight);
			break;
			
		case 5:
			pieza = new Rectangle(ap1X - ((baseWidth - 75) / 2 - 2), pos5Y, baseWidth - 75, baseHeight);
			break;
			
		case 6:
			pieza = new Rectangle(ap1X - ((baseWidth - 90) / 2 - 2), pos6Y, baseWidth - 90, baseHeight);
			break;
			
		case 7:
			pieza = new Rectangle(ap1X - ((baseWidth - 105) / 2 - 2), pos7Y, baseWidth - 105, baseHeight);
			break;

		case 8:
			pieza = new Rectangle(ap1X - ((baseWidth - 120) / 2 - 4), pos8Y, baseWidth - 120, baseHeight);
			break;
		}
	}

	@Override
	public String toString() {
		return "Moneda [denominacion=" + denominacion + "]";
	}
}
