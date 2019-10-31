package com.pruebas;

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

public class TimerWait extends JPanel implements Runnable {
	
	public int x = 30;
	
	public int cont = 0;

	public boolean flag = false;
	
	public void crearHilo() {
		System.out.println("Crear hilo thread: " + Thread.currentThread());
	}
	
	//Timer, debe terminar para seguir con el metodo run
	public Timer timer = new Timer(0, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			System.out.println("timer thread: " + Thread.currentThread());
			
			synchronized (thread.currentThread()) {
				System.out.println("Soy el cuerpo del timer, FUNCIONAAA");
			}
		}
	});
	
	
	//Creacion del hilo
	public Thread thread = new Thread(this);
	
	//Cuerpo del hilo, instrucciones a ejecutar
	@Override
	public void run() {
		System.out.println("run thread: " + thread.currentThread());
		
		//Esperar a que termine el Timer para seguir
		synchronized (thread) {
			System.out.println("Soy el cuerpo de run");
			
			timer.setRepeats(false);
			
			timer.start();
			
			System.out.println("Current thread del run: " + Thread.currentThread());
			
			//Espera del metodo
			synchronized (thread.currentThread()) {
				try {
					timer.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	//Construccion de la ventana y botones
	public TimerWait() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JButton button = new JButton("Dale");
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				metodo();
			}
		});
		
		add(button);
	}
	
	public void metodo() {
		synchronized (thread) {
			System.out.println("Inicia el metodo");
			
			thread.start();
			
			System.out.println("Metodo thread: " + Thread.currentThread());
			
			try {
				thread.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Acaba el metodo");
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.fillRect(x, 40, 50, 10);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		TimerWait timerWait = new TimerWait();
		
		frame.add(timerWait);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600, 300));
		
		frame.setVisible(true);
		
		System.out.println("Hilo main: " + Thread.currentThread());
	}

	
	
}
