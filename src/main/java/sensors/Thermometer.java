package sensors;

import abstracts.AbstractSensor;
import interfaces.PromptInput;

public class Thermometer extends AbstractSensor {

	public static final int MIN_VALUE = -100;
	public static final int MAX_VALUE =  100;
	public static final int COLD_TRESHOLD = 15;
	public static final int HOT_TRESHOLD  = 35;
	
	public Thermometer(String itemName, PromptInput prompt) {
		super(itemName, prompt);
	}
}
