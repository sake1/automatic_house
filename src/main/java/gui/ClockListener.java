package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ClockListener implements KeyListener {

	private JLabel timeLabel;
	private JTextField timeTextField;
	
	public ClockListener(JLabel timeLabel, JTextField timeTextField){
    	this.timeLabel = timeLabel;
    	this.timeTextField = timeTextField;
    }
	
	public void keyReleased(KeyEvent arg0) {
		String time = timeTextField.getText();
		time = new StringBuffer(time).insert(time.length()-2, ":").toString();
		timeLabel.setText("Time " + time);
	}

	public void keyTyped(KeyEvent arg0) {
		// Do nothing
	}

	public void keyPressed(KeyEvent e) {
		// Do nothing
	}
}
