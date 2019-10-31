package com.pruebas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends JPanel {

	private int xInicio = 100;
	private int xFinal = 400;

	private boolean flag = false;
	
	private Movimiento movimiento;

	public Panel() {
		movimiento = new Movimiento();

	}
	
	public void mover() {
		if (!flag) {

			for (; xInicio < xFinal; xInicio++) {
				try {
					Thread.sleep(5);
				} catch (Exception e2) {
					// e2.printStackTrace();
				}
				repaint();
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		update(g);
	}

	@Override
	public void update(Graphics g) {
		// super.update(g);

		g.fillRect(xInicio, 100, 100, 30);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		Panel panel = new Panel();
		
		JButton button = new JButton("Pijaa");
		
		frame.add(button);
		frame.add(panel);
		
		frame.setVisible(true);
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("HOla");
				panel.mover();
			}
		});
		
		
	}
}