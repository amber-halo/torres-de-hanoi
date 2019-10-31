package com.pruebas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class TimerWait2 extends JFrame {
	
	public int x = 30;
	public int y = 40;
	
	public boolean flag = false;
	
	JPanel marco = new JPanel();
	JPanel botones = new JPanel();
	
	JButton button = new JButton();
	
	//Construccion de la ventana y botones
	public TimerWait2() {	
		initComponents();
	}
	
	public void initComponents() {
		marco.setLayout(new BorderLayout());
		
		button.setAction(new Mover(this));
		button.setText("Dale al boton");
		botones.add(button, BorderLayout.SOUTH);
		
		marco.add(botones);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setPreferredSize(new Dimension(800, 200));
		
		getContentPane().add(marco);
		
		this.setTitle("Ventana");
		
		pack();
	}

	//Metodos paint y main para invocar weas
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		g.fillRect(x, y, 100, 50);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new TimerWait2().setVisible(true);
				
			}
		});
		
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}

	
	
}
