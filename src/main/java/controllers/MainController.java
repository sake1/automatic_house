package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import abstracts.AbstractActorController;
import abstracts.AbstractSensor;
import gui.GUI;
import interfaces.Actor;
import interfaces.ActorController;
import interfaces.Sensor;

public class MainController implements Observer {
	
	public static final int TERMINAL_PROMPT = 1;
	public static final int GUI_INTERFACE = 2;
	
	public static int mode;
	
	private List<Sensor> sensors;
	private List<ActorController> subControllers;
	private GUI gui;

	public MainController() {
		this.sensors = new ArrayList<Sensor>();
		this.subControllers = new ArrayList<ActorController>();
	}
	
	public void setMode(int mode) {
		MainController.mode = mode;
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
	
	public void begin(int mode) {
		setMode(mode);
		if(mode == TERMINAL_PROMPT) {
			for(Sensor s : sensors) {
				s.promptInput();
			}
		} else if(mode == GUI_INTERFACE) {
			gui = new GUI("Automatic House");
			gui.addTitle("Sensors");
			for(Sensor s : sensors) {
				gui.addSensor(s);
			}
			gui.addTitle("Actors");
			for(ActorController ac : subControllers) {
				List<Actor> actors = ((AbstractActorController) ac).getActors();
				for(Actor a : actors) {
					gui.addActor(a);
				}
			}
			gui.start();
		}
	}
}
