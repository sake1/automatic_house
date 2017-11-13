package gui;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ThermometerListener implements ChangeListener {

	private JLabel thermometerLabel;
	
	public ThermometerListener(JLabel thermometerLabel){
    	this.thermometerLabel = thermometerLabel;
    }
    
	public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            int temperature = (int)source.getValue();
            thermometerLabel.setText("Thermometer " + temperature);
        }    
    }
}
