package com.project.automatic_house;

import interfaces.Printer;

public class AirConditioner extends AbstractActor {

	public static final int OFF         = 0;
	public static final int COOLER_MODE = 1;
	public static final int HEATER_MODE = 2;
	
	public AirConditioner(String itemName, Printer printer) {
		super(itemName, printer);
	}
}
