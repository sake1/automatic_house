package sensors;

import abstracts.AbstractSensor;
import interfaces.PromptInput;

public class Anemometer extends AbstractSensor {

	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 12;
	// If wind scale is bigger than  threshold, declare there is storm outside
	public static final int CALM_WIND_THRESHOLD = 6;
	
	public Anemometer(String itemName, PromptInput prompt) {
		super(itemName, prompt);
	}
}
