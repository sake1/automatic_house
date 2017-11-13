package utils;

import java.util.Scanner;

import actors.AirConditioner;
import actors.Window;
import controllers.AirConditionerController;
import controllers.MainController;
import controllers.WindowController;
import printers.AirConditionerPrinter;
import printers.WindowPrinter;
import prompts.AnemometerPrompt;
import prompts.ClockPrompt;
import prompts.ThermometerPrompt;
import sensors.Anemometer;
import sensors.Clock;
import sensors.Thermometer;

public class Tester {

	public static void main(String[] args) {
		System.out.println("Select Mode:");
		System.out.println("[1] Terminal");
		System.out.println("[2] GUI");
		System.out.print("? ");
		
		Scanner scan = new Scanner(System.in);
		int respond = Integer.parseInt(scan.nextLine());
		
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
		
		if(respond == 1) {
			m.begin(MainController.TERMINAL_PROMPT);
		} else if(respond == 2) {
			m.begin(MainController.GUI_INTERFACE);
		}
	}
}
