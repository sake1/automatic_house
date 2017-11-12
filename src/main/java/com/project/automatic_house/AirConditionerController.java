package com.project.automatic_house;

import java.util.ArrayList;
import java.util.List;

import interfaces.ActorController;
import interfaces.Sensor;

public class AirConditionerController implements ActorController {

	private List<AirConditioner> airConditioners;
	
	public AirConditionerController() {
		airConditioners = new ArrayList<AirConditioner>();
	}
	
	public void addAirConditioner(AirConditioner ac) {
		airConditioners.add(ac);
	}

	public void onUpdatedSensors(List<Sensor> sensors) {
		// Find sensor with the type of Thermometer
		for(Sensor s : sensors) {
			if(isThermometer(s)) {
				int value = ((Thermometer) s).getProperties().getValue();
				if(isTemperatureCold(value)) {
					changeActorState(AirConditioner.HEATER_MODE);
					return;
				} else if(isTemperatureHot(value)) {
					changeActorState(AirConditioner.COOLER_MODE);
					return;
				}
			}
		}
		
		// No sensors indicate that air conditioner should be turned on
		// Proceed to turn off air conditioner
		changeActorState(AirConditioner.OFF);
	}

	private boolean isTemperatureCold(int value) {
		return value <= Thermometer.COLD_TRESHOLD && value != Item.DEFAULT;
	}

	private boolean isTemperatureHot(int value) {
		return value >= Thermometer.HOT_TRESHOLD && value != Item.DEFAULT;
	}

	private boolean isThermometer(Sensor s) {
		return s instanceof Thermometer;
	}
	
	public void changeActorState(int newValue) {
		for(AirConditioner ac : airConditioners) {
			ac.getProperties().setValue(newValue);
		}
	}
}
