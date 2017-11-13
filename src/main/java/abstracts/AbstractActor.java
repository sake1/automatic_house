package abstracts;

import java.util.Observable;
import java.util.Observer;

import controllers.MainController;
import interfaces.Actor;
import interfaces.Printer;
import utils.Item;

public abstract class AbstractActor extends Observable implements Actor, Observer {

	private Item properties;
	private Printer printer; 
	
	public AbstractActor(String itemName, Printer printer) {
		super();
		this.properties = new Item(itemName);
		this.properties.addObserver(this);
		this.printer = printer;
	}
	
	public Item getProperties() {
		return properties;
	}

	public void setProperties(Item properties) {
		this.properties = properties;
	}

	public void print() {
		printer.print(properties);
	}
	
	public void changeState(int newValue) {
		properties.setValue(newValue);
	}

	public void update(Observable arg0, Object arg1) {
		if(MainController.mode == MainController.TERMINAL_PROMPT) {
			print();
		} else if(MainController.mode == MainController.GUI_INTERFACE) {
			setChanged();
		    notifyObservers();
		    clearChanged();
		}
	}
}
