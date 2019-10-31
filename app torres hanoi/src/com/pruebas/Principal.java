package com.pruebas;

import java.awt.Rectangle;
import java.util.Stack;

public class Principal {
	private int tama�o = 5;
	
	private Rectangle[] vector;
	
	private Stack<Rectangle> stack;
	
	public Principal() {
		stack = new Stack<>();
		vector = new Rectangle[tama�o];
	}
	
	public void cargar() {
		for (int i = 0; i < tama�o; i++) {
			vector[i] = new Rectangle(100,100);
		}
	}
	
	public void a�adir() {
		for (int i = 0; i < tama�o; i++) {
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
		principal.a�adir();
		principal.visualizar();
	}
}
