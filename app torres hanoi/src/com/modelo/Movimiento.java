package com.modelo;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingWorker;

public class Movimiento extends AbstractAction {
	
	/* Clases necesarias */
	private PanelHilo panelHilo;
	private Controlador controlador;
	private PanelBotones panelBotones;
	
	/* Constructor */
	public Movimiento(PanelHilo panelHilo, Controlador controlador, PanelBotones panelBotones) {
		this.panelHilo = panelHilo;
		this.controlador = controlador;
		this.panelBotones = panelBotones;
	}

	/* Iniciar controlador y juego */
	@Override
	public void actionPerformed(ActionEvent e) {
		final SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				
				controlador.iniciar(panelHilo);	
				
				controlador.bandera = true;

				panelBotones.btDetener.setEnabled(false);
				panelBotones.reiniciar.setEnabled(true);
				
				return null;
			}
		};
		worker.execute();
	}
	
}