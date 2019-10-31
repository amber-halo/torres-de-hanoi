package com.pruebas;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingWorker;

public class Mover extends AbstractAction {
	
	private TimerWait2 timerWait2;
	
	public Mover(TimerWait2 timerWait2) {
		this.timerWait2 = timerWait2;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		final SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				
				for (; timerWait2.x <= 300; timerWait2.x++) {
					try {
						Thread.sleep(5);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					timerWait2.repaint();
				}
				
				System.out.println(timerWait2.x);
		
				return null;
			}
		};
		worker.execute();
	}
	
}
