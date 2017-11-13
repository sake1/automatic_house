package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import abstracts.AbstractSensor;
import interfaces.Sensor;

public class ClockListener implements KeyListener {

	private JLabel timeLabel;
	private JTextField timeTextField;
	private Sensor sensor;
	
	public ClockListener(JLabel timeLabel, JTextField timeTextField, Sensor sensor){
    	this.timeLabel = timeLabel;
    	this.timeTextField = timeTextField;
    	this.sensor = sensor;
    }
	
	public void keyReleased(KeyEvent arg0) {
		String time = timeTextField.getText();
		if(time.length() > 2){
			time = new StringBuffer(time).insert(time.length()-2, ":").toString();
			timeTextField.setText("Time " + time);
		}
		((AbstractSensor) sensor).getProperties().setValue(Integer.parseInt(timeTextField.getText()));
	}

	public void keyTyped(KeyEvent arg0) {
		// Do nothing
	}

	public void keyPressed(KeyEvent e) {
		// Do nothing
	}
}
