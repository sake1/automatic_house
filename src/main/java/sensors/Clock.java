package sensors;

import abstracts.AbstractSensor;
import interfaces.PromptInput;

public class Clock extends AbstractSensor {

	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 2400;
	public static final int DAY_START = 600;
	public static final int NIGHT_START = 1800;
	
	public Clock(String itemName, PromptInput prompt) {
		super(itemName, prompt);
	}

}
