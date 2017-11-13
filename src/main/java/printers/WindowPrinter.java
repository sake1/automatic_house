package printers;

import actors.Window;
import interfaces.Printer;
import utils.Item;

public class WindowPrinter implements Printer {

	public void print(Item item) {
		if(item.getValue() == Window.OPEN) {
			System.out.println(item.getName() + " opened");
		} else if(item.getValue() == Window.CLOSE) {
			System.out.println(item.getName() + " closed");
		} else {
			System.out.println("Command not recognized");
		}
	}
}
