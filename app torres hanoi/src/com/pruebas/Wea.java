package com.pruebas;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Wea extends JPanel{
	
	private int x = 100;
	private int velX = 2;
	
	public Wea() {
		JButton button = new JButton("pija");
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//				mover();
			}
		});
		
		add(button);
		
//		mover();
		
		
	}
	
	public void desplazar() {
		for (int i = 1; i < 20; i++) {
			mover();
		}
	}
	
	public void mover() {
		for (; x < 400; x++) {
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				// TODO: handle exception
			}
			repaint();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.fillRect(x, 100, 100, 50);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Wea wea = new Wea();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(wea);
		
		frame.setVisible(true);

	}

}
