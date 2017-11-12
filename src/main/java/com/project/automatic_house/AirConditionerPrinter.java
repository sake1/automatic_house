package com.project.automatic_house;

import interfaces.Printer;

public class AirConditionerPrinter implements Printer {

	public void print(Item item) {
		if(item.getValue() == AirConditioner.OFF) {
			System.out.println(item.getName() + " turned off");
		} else if(item.getValue() == AirConditioner.COOLER_MODE) {
			System.out.println("Setting " + item.getName() + " into cooler mode");
		} else if(item.getValue() == AirConditioner.HEATER_MODE) {
			System.out.println("Setting " + item.getName() + " into heater mode");
		} else {
			System.out.println("Command not recognized");
		}
	}
}
