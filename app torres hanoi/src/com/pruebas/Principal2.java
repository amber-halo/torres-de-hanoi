package com.pruebas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Principal2 extends JPanel {
	
	int x = 0 , velX  = 2;
	
	public boolean flag = false;
	
	public int numero = 1;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
//		g.fillRect(x, 30, 90, 10);
		
		if (numero == 1 ) {
			g.setColor(Color.RED);
			g.fillRect(x, 30, 50, 30);
		}
		
		if (numero == 2) {
			System.out.println("wea");
			g.fillRect(x, 60, 50, 30);
		}
		
	}

	public static void main(String[] args) {
		Principal2 principal2 = new Principal2();
		JFrame jFrame = new JFrame();
		
		jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
		
		jFrame.setTitle("Panel");
		jFrame.setSize(new Dimension(600, 400));
		
		JButton button = new JButton("Pija");

		String[] opciones = {"1", "2", "3"};
		JComboBox box = new JComboBox(opciones);
		
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.add(principal2);
		jFrame.add(button);
		jFrame.add(box);
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		box.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int item = 0;
				
				String opcion = box.getSelectedItem().toString();
				item = Integer.parseInt(opcion);
				
				principal2.numero = item;
				
				System.out.println(principal2.numero);
				
				
				
				principal2.repaint();
			}
		});

	}

}
