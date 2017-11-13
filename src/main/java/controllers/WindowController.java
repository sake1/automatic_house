package controllers;

import java.util.ArrayList;
import java.util.List;

import abstracts.AbstractActorController;
import actors.Window;
import interfaces.Actor;
import interfaces.ActorController;
import interfaces.Sensor;
import sensors.Anemometer;
import sensors.Clock;
import utils.Item;

public class WindowController extends AbstractActorController implements ActorController {

	public void onUpdatedSensors(List<Sensor> sensors) {
		// Find sensor with the type of Clock or Anemometer
		for(Sensor s : sensors) {
			if(isAClock(s)) {
				int value = ((Clock) s).getProperties().getValue();
				if(isNightTime(value)) {
					changeActorState(Window.CLOSE);
					return;
				}
			} else if(isAnAnemometer(s)) {
				int value = ((Anemometer) s).getProperties().getValue();
				if(thereIsStormOutside(value)) {
					changeActorState(Window.CLOSE);
					return;
				}
			}
		}
		
		// No sensors indicate that windows should be closed
		// Proceed to open windows
		changeActorState(Window.OPEN);
	}

	private boolean isNightTime(int value) {
		return Clock.DAY_START < value && value >= Clock.NIGHT_START && value != Item.DEFAULT;
	}
	
	private boolean thereIsStormOutside(int value) {
		return value > Anemometer.CALM_WIND_THRESHOLD && value != Item.DEFAULT;
	}

	private boolean isAnAnemometer(Sensor s) {
		return s instanceof Anemometer;
	}

	private boolean isAClock(Sensor s) {
		return s instanceof Clock;
	}
}
