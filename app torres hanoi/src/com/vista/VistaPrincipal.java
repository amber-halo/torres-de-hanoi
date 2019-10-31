package com.vista;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.modelo.Controlador;
import com.modelo.Moneda;
import com.modelo.Movimiento;
import com.modelo.PanelBotones;
import com.modelo.PanelHilo;

public class VistaPrincipal extends JFrame {
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;
	
	public VistaPrincipal() {
		/* Crear JFrame(ventana) */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setAutoRequestFocus(true);
		setBounds(290, 140, 800, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		
		/* Creacion del controlador y el panel Hilo */
		PanelBotones panelBotones = new PanelBotones(WIDTH - 700, HEIGHT);
		PanelHilo panelHilo = new PanelHilo();
		Controlador controlador = new Controlador();
		panelHilo.setControlador(controlador);
		controlador.setPanelBotones(panelBotones);
		
		/////////////* Panel Principal *//////////////////////
		JPanel panelPrincipal = (JPanel) getContentPane();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.X_AXIS));		
		
		/* Panel Hilo */
		JPanel panelSecundario = new JPanel();
		panelSecundario.add(panelHilo);
			
		/* Añadir panel de botones e hilo */
		panelPrincipal.add(panelSecundario);
		panelPrincipal.add(panelBotones);
		panelBotones.reiniciar.setEnabled(false);
		panelBotones.btDetener.setEnabled(false);
		
		////////////* Control de botones *////////////////////
		panelBotones.btSetPiezas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Por conveniencia, elija valores en orden ascendente.");
				setDenominacion(controlador);
			}
		});
		
		/* Lista de cantidad de piezas */
		panelBotones.cbPiezas.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int item = 0;
				
					try {
						
						String itemString = panelBotones.cbPiezas.getSelectedItem().toString();
						item = Integer.parseInt(itemString);
						
						controlador.cargarPiezas(item);

						panelBotones.movimientos.setText("Movimientos: " + getMovimientos(item));
						
						panelHilo.corriendo = true;
						
						panelHilo.noPiezas = item;
						
						panelHilo.repaint();
						
					} catch (ClassCastException e2) {
						e2.printStackTrace();
					}
				
			}
		});	
		
		/* Boton Iniciar */
		panelBotones.btIniciar.setAction(new Movimiento(panelHilo, controlador, panelBotones));
		panelBotones.btIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelBotones.btIniciar.setEnabled(false);
				panelBotones.cbPiezas.setEnabled(false);
				
				panelBotones.btDetener.setEnabled(true);
				
				panelBotones.velocidad.setText("Velocidad: " + controlador.velocidad);
			}
		});
		
		panelBotones.btIniciar.setText("Iniciar");
		
		/* Boton detener */
		panelBotones.btDetener.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.corriendo = !controlador.corriendo;
			}
		});
		
		/* Boton Aumentar Velocidad */
		panelBotones.btAumentar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.aumentarVel();
				
				panelBotones.velocidad.setText("Velocidad: " + controlador.velocidad);
			}
		});
		
		/* Boton Disminuir Velocidad */
		panelBotones.btDisminuir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlador.disminuirVel();
				
				panelBotones.velocidad.setText("Velocidad: " + controlador.velocidad);
			}
		});
		
		/* Boton Reiniciar */
		panelBotones.reiniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (controlador.bandera) {
					setVisible(false);
					iniciar();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		
		iniciar();
		
	}
	
	/* Iniciar Ventana */
	public static void iniciar() {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VistaPrincipal().setVisible(true);
				
			}
		});
	}
	
	/* Movimientos mínimos */
	public static int getMovimientos(int item) {
		return (int) (Math.pow(2, item) - 1);
	}
	
	/* Botón cambiar valores de piezas */
	public static void setDenominacion(Controlador controlador) {
		for (int i = 0; i < controlador.vec.length; i++) {
			String cadena = JOptionPane.showInputDialog("Valor actual de pieza no. " + (i+1) + ": " + controlador.vec[i].denominacion  + ". Valor nuevo: ");
			try {
				int valor = Integer.parseInt(cadena);
				controlador.vec[i].denominacion = valor;
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
		}
	}
	
}
