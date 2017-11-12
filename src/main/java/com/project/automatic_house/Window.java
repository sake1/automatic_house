package com.project.automatic_house;

import interfaces.Printer;

public class Window extends AbstractActor {

	public static final int OPEN  = 1;
	public static final int CLOSE = 0;
	
	public Window(String itemName, Printer printer) {
		super(itemName, printer);
	}
}
