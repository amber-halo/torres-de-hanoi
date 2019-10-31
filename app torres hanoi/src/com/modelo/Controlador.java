package com.modelo;

import java.util.Stack;

public class Controlador {
	
	/* Variables generales */
	public boolean corriendo = false;
	
	public boolean bandera = false;
	
	private int piezas = 1;
	
	public Moneda tempPieza;
	
	public long velocidad = 5;
	
	private PanelBotones panelBotones;
	
	private int movimientos = 0;
	
	/* Creacion de monedas y pilas */
	public Moneda moneda1 = new Moneda(1);
	public Moneda moneda2 = new Moneda(2);
	public Moneda moneda3 = new Moneda(3);
	public Moneda moneda4 = new Moneda(4);
	public Moneda moneda5 = new Moneda(5);
	public Moneda moneda6 = new Moneda(6);
	public Moneda moneda7 = new Moneda(7);
	public Moneda moneda8 = new Moneda(8);
	
	public Moneda[] vec = new Moneda[] {moneda1, moneda2, moneda3, moneda4, moneda5, moneda6, moneda7, moneda8};
	
	public Stack<Moneda> torre1; 
	public Stack<Moneda> torre2; 
	public Stack<Moneda> torre3; 
	
	/* Variables necesitadas para movimiento de piezas */
	private static int alturaMax = 30;
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 500;
	private final int baseWidth = 150;
	
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
	
	private final int baseY = HEIGHT - 100;
	
	/* Niveles en Y */
	private int pos1Y = baseY - 11;
	private int pos2Y = baseY - 21;
	private int pos3Y = baseY - 31;
	private int pos4Y = baseY - 41;
	private int pos5Y = baseY - 51;
	private int pos6Y = baseY - 61;
	private int pos7Y = baseY - 71;
	private int pos8Y = baseY - 81;
	
	private int posY;
	
	/* Constructor */
	public Controlador() {
		
		torre1 = new Stack<>();
		torre2 = new Stack<>();
		torre3 = new Stack<>();

	}
	
	/* Cargar número de piezas */
	public void cargarPiezas(int piezas) {
		this.piezas = piezas;
		
		if (torre1.isEmpty()) {
			cargar(); 
		}
		else {
			torre1 = new Stack<>();
			cargar();
		}
	}
	
	/* Cargar piezas en las pilas */
	public void cargar() {
		for (int i = 0; i < piezas; i++) {
			torre1.push(vec[i]);
		}
	}

	/* Iniciar juego desde las  pilas */
	public void iniciar(PanelHilo panelHilo) {
		hanoi(piezas, torre1, torre2, torre3, ap1X, ap2X, ap3X, panelHilo);
	}
	
	/* Pausar juego */
	public void pausar() {
		if (corriendo) {
			while (corriendo) {
				try {
					Thread.sleep(20);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} else {
			corriendo = false;
		}
	}
	
	/* Aumentar velocidad del juego */
	public void aumentarVel() {
		velocidad--;
	}
	
	/* Disminuir velocidad del juego */
	public void disminuirVel() {
		velocidad++;
	}
	
	/* Actualizar número de movimientos ventana */
	public void actualizarContador(PanelBotones panelBotones) {
		movimientos++;
		panelBotones.contador.setText("" + movimientos);
	}
	
	/* Método Hanoi */
	public Stack<Moneda> hanoi(int piezas, Stack<Moneda> origen, Stack<Moneda> aux, Stack<Moneda> destino, int ap1, int ap2, int ap3, PanelHilo panelHilo) {
		if (piezas == 0) {
			return destino;
		} else {
			hanoi(piezas - 1, origen, destino, aux, ap1, ap3, ap2, panelHilo);
			mover(origen, destino, ap1, ap3, panelHilo);
			hanoi(piezas - 1, aux, origen, destino, ap2, ap1, ap3, panelHilo);
		}
		
		return destino;	
	}

	/* Mover piezas en las pilas */
	public void mover(Stack<Moneda> originPos, Stack<Moneda> finalPos, int apOrigen, int apDestino, PanelHilo panelHilo) {
		
			tempPieza = originPos.pop();	
			finalPos.push(tempPieza);		
			
			int nivelTorre = finalPos.size();
			
			panelHilo.tempMoneda = tempPieza;
			panelHilo.apOrigen = apOrigen;
			panelHilo.apFinal = apDestino;
			
			switch (nivelTorre) {
			case 1:
				posY = pos1Y;
				break;
				
			case 2:
				posY = pos2Y;
				break;
				
			case 3:
				posY = pos3Y;
				break;
				
			case 4:
				posY = pos4Y;
				break;
				
			case 5:
				posY = pos5Y;
				break;
				
			case 6:
				posY = pos6Y;
				break;
				
			case 7:
				posY = pos7Y;
				break;
				
			case 8:
				posY = pos8Y;
				break;
			}

			actualizarContador(panelBotones);
			
			desplazar(tempPieza, apOrigen, apDestino, posY ,panelHilo);
		
	}
	
	/* Mover las piezas gráficamente */
	public void desplazar(Moneda tempMoneda, int apOrigen, int apDestino, int posY, PanelHilo panelHilo) {	
		moverArriba(tempMoneda, panelHilo);
		moverX(tempMoneda, apOrigen, apDestino, panelHilo);
		moverAbajo(tempMoneda, posY, panelHilo);
	}
	
	/* Método para actualización gráfica continua */
	public void dormir(PanelHilo panelHilo) {
		try {
			Thread.sleep(velocidad);
		} catch (Exception e) {
			// TODO: handle exception
		}
		panelHilo.repaint();
	}
	
	/* Mover pieza hacia arriba */
	public void moverArriba(Moneda tempMoneda, PanelHilo panelHilo) {
		for (; tempMoneda.pieza.y >= alturaMax; tempMoneda.pieza.y--) {
			pausar();
			dormir(panelHilo);
		}
	}
	
	/* Mover pieza hasta torre destino */
	public void moverX(Moneda tempMoneda, int apOrigen ,int apDestino, PanelHilo panelHilo) {
		if (apOrigen < apDestino) {
			for (; tempMoneda.pieza.x <= apDestino - (tempMoneda.pieza.width / 2 - 3); tempMoneda.pieza.x++) {
				pausar();
				dormir(panelHilo);
			}
		} else {
			for (; tempMoneda.pieza.x >= apDestino - (tempMoneda.pieza.width / 2 - 4); tempMoneda.pieza.x--) {
				pausar();
				dormir(panelHilo);
			}
		}
	}
	
	/* Mover pieza hacia abajo */
	public void moverAbajo(Moneda tempMoneda, int posY, PanelHilo panelHilo) {
		for (; tempMoneda.pieza.y <= posY; tempMoneda.pieza.y++) {
			pausar();
			dormir(panelHilo);
		}
	}
	
	/////////////* Getters & Setters */  //////////////////

	public int getPiezas() {
		return piezas;
	}

	public void setPiezas(int piezas) {
		this.piezas = piezas;
	}
	
	public void setPanelBotones(PanelBotones panelBotones) {
		this.panelBotones = panelBotones;
	}

	public Moneda getMoneda1() {
		return moneda1;
	}

	public void setMoneda1(Moneda moneda1) {
		this.moneda1 = moneda1;
	}

	public Moneda getMoneda2() {
		return moneda2;
	}

	public void setMoneda2(Moneda moneda2) {
		this.moneda2 = moneda2;
	}

	public Moneda getMoneda3() {
		return moneda3;
	}

	public void setMoneda3(Moneda moneda3) {
		this.moneda3 = moneda3;
	}

	public Moneda getMoneda4() {
		return moneda4;
	}

	public void setMoneda4(Moneda moneda4) {
		this.moneda4 = moneda4;
	}

	public Moneda getMoneda5() {
		return moneda5;
	}

	public void setMoneda5(Moneda moneda5) {
		this.moneda5 = moneda5;
	}

	public Moneda getMoneda6() {
		return moneda6;
	}

	public void setMoneda6(Moneda moneda6) {
		this.moneda6 = moneda6;
	}

	public Moneda getMoneda7() {
		return moneda7;
	}

	public void setMoneda7(Moneda moneda7) {
		this.moneda7 = moneda7;
	}

	public Moneda getMoneda8() {
		return moneda8;
	}

	public void setMoneda8(Moneda moneda8) {
		this.moneda8 = moneda8;
	}

}
