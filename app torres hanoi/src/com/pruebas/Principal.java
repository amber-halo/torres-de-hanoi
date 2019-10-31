package com.pruebas;

import java.awt.Rectangle;
import java.util.Stack;

public class Principal {
	private int tamaño = 5;
	
	private Rectangle[] vector;
	
	private Stack<Rectangle> stack;
	
	public Principal() {
		stack = new Stack<>();
		vector = new Rectangle[tamaño];
	}
	
	public void cargar() {
		for (int i = 0; i < tamaño; i++) {
			vector[i] = new Rectangle(100,100);
		}
	}
	
	public void añadir() {
		for (int i = 0; i < tamaño; i++) {
			stack.push(vector[i]);
		}
	}
	
	public void visualizar() {
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.cargar();
		principal.añadir();
		principal.visualizar();
	}
}
