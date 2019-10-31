package com.modelo;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBotones extends JPanel {
	
	public boolean iniciar = true;
	
	public int item = 1;
	
	public JButton btSetPiezas;
	public JComboBox cbPiezas;
	public JButton btIniciar;
	public JButton btDetener;
	public JLabel movimientos;
	public JButton btAumentar;
	public JButton btDisminuir;
	public JLabel velocidad;
	public JLabel contador;
	public JButton reiniciar;
	
	public PanelBotones(int width, int height) {
		
		/* Crear panel */
		setPreferredSize(new Dimension(width, height));
		setSize(width, height);
		setLayout(new GridLayout(13, 1, 0, 10));
		
		/* Creacion de lista */
		String[] opciones = {"1", "2", "3", "4", "5", "6", "7", "8"};
		cbPiezas = new JComboBox(opciones);
		
		JLabel lbPiezas = new JLabel("No. de piezas");
		lbPiezas.setHorizontalAlignment((int) LEFT_ALIGNMENT);
		
		/* Creacion de botones Iniciar y Detener */	
		btSetPiezas = new JButton("Valores de piezas");
		btIniciar = new JButton();
		btDetener = new JButton("Detener");
		btAumentar = new JButton("Aumentar");
		btDisminuir = new JButton("Disminuir");
		reiniciar = new JButton("Reiniciar");
		
		/* Creacion de celdas vacias */
		JLabel e1 = new JLabel("");
		JLabel e2 = new JLabel("");
		JLabel e3 = new JLabel("");
		JLabel e4 = new JLabel("");
		JLabel e5 = new JLabel("");
		
		/* Creacion de texto para movimientos y velocidad */
		movimientos = new JLabel();
		movimientos.setHorizontalAlignment(JLabel.CENTER);
		
		velocidad = new JLabel();
		velocidad.setHorizontalAlignment(JLabel.CENTER);
		velocidad.setText("Velocidad: " + 5);
		
		contador = new JLabel();
		contador.setHorizontalAlignment(JLabel.RIGHT);
		
		/* Añadir todos los botones */
		add(btSetPiezas);
//		add(e1);
		add(e2);
		
		add(lbPiezas);

		add(cbPiezas);
		add(btIniciar);
		add(btDetener);
		add(reiniciar);
		
		add(movimientos);
		
		add(velocidad);
		add(btAumentar);
		add(btDisminuir);
		
		add(e3);
//		add(e4);
		
		add(contador);
		
		
	}
}
