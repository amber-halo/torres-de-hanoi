package com.modelo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelHilo extends JPanel {
	
	/* Variables generales */
	public boolean corriendo = true;
	
	private Controlador controlador;
	
	public Moneda tempMoneda;
	public int apOrigen;
	public int apFinal;
	public int posY;
	
	public int noPiezas = 0;
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 500;
	
	/* Tamaños y posiciones de piezas base */
	private final int baseWidth = 150;
	private final int baseHeight = 10;
	private final int baseY = HEIGHT - 100;
	private final int b1pX = 0;
	private final int b2pX = 230;
	private final int b3pX = WIDTH - 150;
	
	/* Tamaños y posiciones de apiladores */
	private final int apWidth = 10;
	private final int apHeight = 170;
	private final int apY = HEIGHT - 260;
	private final int ap1X = (baseWidth / 2) - 2;
	private final int ap2X = (b2pX + baseWidth / 2) - 2;
	private final int ap3X = (b3pX + baseWidth / 2) - 2;
	
	/* Colores de piezas */
	private Random random = new Random();
	
	private Color color1;
	private Color color2;
	private Color color3;
	private Color color4;
	private Color color5;
	private Color color6;
	private Color color7;
	private Color color8;
	
	private Color[] vecColores = new Color[] {color1, color2, color3, color4, color5, color6, color7, color8};
	
	/* Constructor */
	public PanelHilo() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		for (int i = 0; i < vecColores.length; i++) {
			vecColores[i] = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		}

	}
	
	/* Imprimir suma de valores actuales en cada torre */
	public String getSumaValores(Stack<Moneda> stack) {
		String cadena = "";
		int suma = 0;
		for (int i = 0; i < stack.size(); i++) {
			suma += stack.get(i).denominacion;
		}
		
		return cadena += suma;
	}
	
	/* Pintar piezas en la pantalla */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		/* Dibujar piezas base */	
		g.fillRect(b1pX, baseY, baseWidth, baseHeight);
		g.fillRect(b2pX, baseY, baseWidth, baseHeight);
		g.fillRect(b3pX, baseY, baseWidth, baseHeight);
		
		/* Dibujar apiladores */
		g.fillRect(ap1X, apY, apWidth, apHeight);
		g.fillRect(ap2X, apY, apWidth, apHeight);
		g.fillRect(ap3X, apY, apWidth, apHeight);
		
		
		g.drawString("Torre 1: " + getSumaValores(controlador.torre1), b1pX + 50, baseY + 40);
		g.drawString("Torre 2: " + getSumaValores(controlador.torre2), b2pX + 50, baseY + 40);
		g.drawString("Torre 3: " + getSumaValores(controlador.torre3), b3pX + 50, baseY + 40);
		
		/* Dibujar piezas */
		for (int i = 0; i < noPiezas; i++) {
			g.setColor(vecColores[i]);
			g.fillRect(controlador.vec[i].pieza.x, controlador.vec[i].pieza.y, controlador.vec[i].pieza.width, controlador.vec[i].pieza.height);
		}
		
	}
	
	
	////////////////* Getters & Setters */   ////////////////////

	public int getNoPiezas() {
		return noPiezas;
	}

	public void setNoPiezas(int noPiezas) {
		this.noPiezas = noPiezas;
	}

	public int getAp1X() {
		return ap1X;
	}

	public int getAp2X() {
		return ap2X;
	}

	public int getAp3X() {
		return ap3X;
	}

	public int getBaseWidth() {
		return baseWidth;
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

}
