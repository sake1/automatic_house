package gui;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import abstracts.AbstractSensor;
import interfaces.Sensor;

public class AnemometerListener implements ChangeListener {

	private JLabel anemometerLabel;
	private Sensor sensor;
	
	public AnemometerListener(JLabel anemometerLabel, Sensor sensor){
    	this.anemometerLabel = anemometerLabel;
    	this.sensor = sensor;
    }
    
	public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            int windSpeed = (int)source.getValue();
            anemometerLabel.setText("Wind Speed " + windSpeed);
            ((AbstractSensor) sensor).getProperties().setValue(windSpeed);
        }    
    }
}
