package gui;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AnemometerListener implements ChangeListener {

	private JLabel anemometerLabel;
	
	public AnemometerListener(JLabel anemometerLabel){
    	this.anemometerLabel = anemometerLabel;
    }
    
	public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
            int windSpeed = (int)source.getValue();
            anemometerLabel.setText("Wind Speed " + windSpeed);
        }    
    }
}
