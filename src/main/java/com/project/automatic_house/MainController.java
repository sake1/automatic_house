package com.project.automatic_house;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import interfaces.ActorController;
import interfaces.Sensor;

public class MainController implements Observer {
	
	private List<Sensor> sensors;
	private List<ActorController> subControllers;

	public MainController() {
		this.sensors = new ArrayList<Sensor>();
		this.subControllers = new ArrayList<ActorController>();
	}
	
	public void addSensor(Sensor sensor) {
		((AbstractSensor) sensor).addObserver(this);
		sensors.add(sensor);
	}
	
	public void addSubController(ActorController controller) {
		subControllers.add(controller);
	}

	public void update(Observable o, Object arg) {
		for(ActorController ac : subControllers) {
			ac.onUpdatedSensors(sensors);
		}
	}
	
	public void begin() {
		for(Sensor s : sensors) {
			s.promptInput();
		}
	}
}
