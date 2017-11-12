package com.project.automatic_house;

import java.util.Observable;

public class Item extends Observable {

	public static final int DEFAULT = -9999;
	
	private String name;
	private int value;
	
	public Item(String name) {
		super();
		this.name = name;
		this.value = -9999;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
		setChanged();
		notifyObservers();
		clearChanged();
	}
}
