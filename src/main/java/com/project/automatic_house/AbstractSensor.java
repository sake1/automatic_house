package com.project.automatic_house;

import java.util.Observable;
import java.util.Observer;

import interfaces.PromptInput;
import interfaces.Sensor;

public abstract class AbstractSensor extends Observable implements Sensor, Observer {

	private Item properties;
	private PromptInput prompt;

	public AbstractSensor(String itemName, PromptInput prompt) {
		super();
		this.properties = new Item(itemName);
		this.properties.addObserver(this);
		this.prompt = prompt;
	}
	
	public Item getProperties() {
		return properties;
	}

	public void setProperties(Item item) {
		this.properties = item;
		setChanged();
		notifyObservers();
		clearChanged();
	}

	public void promptInput() {
		prompt.promptInput(properties);
	}

	public void update(Observable o, Object arg) {
		Item item = (Item) o;
		setProperties(item);
	}
}
