package com.pruebas;

import java.awt.Color;
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
import javax.swing.Timer;

public class Panel2 extends JPanel implements ActionListener {
	
	Timer tm = new Timer(100, this);
	
	int x = 0 , velX  = 2;
	
	public boolean flag = false;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.fillRect(x, 30, 90, 10);
		
		g.setColor(Color.RED);
		g.fillRect(x, 30, 50, 30);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		x = x + velX;
		
		if (flag) {
			Timer timer = new Timer(100, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {	
					System.out.println("holaaaaaaaaaa");
				}
			});
			timer.start();
		}
		
		repaint();
		
	}
	
	public void iniciar() {
		tm.start();
	}

	public static void main(String[] args) {
		Panel2 panel2 = new Panel2();
		JFrame jFrame = new JFrame();
		
		jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
		
		jFrame.setTitle("Panel");
		jFrame.setSize(new Dimension(600, 400));
		
		JButton button = new JButton("Pija");
		JButton button2 = new JButton("Mas pija");
		
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.add(panel2);
		jFrame.add(button);
		jFrame.add(button2);
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel2.iniciar();
			}
		});
		
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel2.flag = true;
				
				
			}
		});

	}

}
