package gui;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import abstracts.AbstractSensor;
import interfaces.Sensor;

public class ThermometerListener implements ChangeListener {

	private JLabel thermometerLabel;
	private Sensor sensor;
	
	public ThermometerListener(JLabel thermometerLabel, Sensor sensor){
    	this.thermometerLabel = thermometerLabel;
    	this.sensor = sensor;
    }
    
	public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            int temperature = (int)source.getValue();
            thermometerLabel.setText(((AbstractSensor) sensor).getProperties().getName() + " measure: " + temperature);
            ((AbstractSensor) sensor).getProperties().setValue(temperature);
        }    
    }
}
