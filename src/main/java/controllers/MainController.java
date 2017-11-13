package controllers;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import abstracts.AbstractActorController;
import abstracts.AbstractSensor;
import actors.AirConditioner;
import actors.Window;
import gui.GUI;
import interfaces.Actor;
import interfaces.ActorController;
import interfaces.Sensor;
import printers.AirConditionerPrinter;
import printers.WindowPrinter;
import prompts.AnemometerPrompt;
import prompts.ClockPrompt;
import prompts.ThermometerPrompt;
import sensors.Anemometer;
import sensors.Clock;
import sensors.Thermometer;

public class MainController implements Observer {
	
	private List<Sensor> sensors;
	private List<ActorController> subControllers;
	private GUI gui;

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
		
		gui.addComponentsToPane(gui.getContentPane());
		gui.pack();
		gui.setResizable(false);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		MainController m = new MainController();
		m.addSensor(new Clock("Clock", new ClockPrompt()));
		m.addSensor(new Anemometer("Anemometer", new AnemometerPrompt()));
		m.addSensor(new Thermometer("Thermometer", new ThermometerPrompt()));
		
		WindowController w = new WindowController();
		w.addActor(new Window("Window", new WindowPrinter()));
		
		AirConditionerController ac = new AirConditionerController();
		ac.addActor(new AirConditioner("Air Conditioner", new AirConditionerPrinter()));
		
		m.addSubController(w);
		m.addSubController(ac);
		m.begin();
	}
}
