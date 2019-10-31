//package com.pruebas;
//
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.Timer;
//
//public class Ventana extends JFrame {
//	
//	private int x = 100;
//	
//	private boolean flag = false;
//
//	
//	
//	
//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//		g.fillRect(x, 40, 50, 10);
//	}
//	
//	public void mover() {
//		if (flag) {
//			
//			while (flag) {
//				x++;
//				try {
//					Thread.sleep(5);
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//				repaint();
//			}
//			
//		}
//	}
//	
//	public Ventana() {
//
//		JButton button = new JButton("Dale");
//		
//		button.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				flag = true;
//				mover();
//			}
//		});
//		
//		JPanel frame = (JPanel) getContentPane();
//		
//		frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
//		
//		setExtendedState(MAXIMIZED_BOTH);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		
//		add(button);
//		
//		setVisible(true);
//		
//		System.out.println("constructor ventana thread: " + Thread.currentThread());
//		
////		mover();
//	}
//	
//	public void metodo() {
//		System.out.println("metodo thread: " + Thread.currentThread());
//
//	}
//	
//	public static void main(String[] args) {
//		
//		new Ventana();
//		
//		System.out.println("main thread: " + Thread.currentThread());
//	}
//}
//
//class Mover extends JPanel {
//	private int x = 30;
//	
//	private boolean flag = true;
//	
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		
//		g.fillRect(x, 40, 50, 10);
//	}
//	
//	public void mover(){
//		for(; x <= 200; x++) {
//			try {
//				Thread.sleep(10);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			repaint();
//		}
//	}
//
//}

