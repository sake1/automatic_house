package prompts;

import java.util.InputMismatchException;
import java.util.Scanner;

import interfaces.PromptInput;
import sensors.Clock;
import utils.InvalidDataFormatException;
import utils.Item;

public class ClockPrompt implements PromptInput {

	private boolean isValidTimeFormat(int time) {
		return Clock.MIN_VALUE <= time && time < Clock.MAX_VALUE && time % 100 < 60; 
	}
	
	public void promptInput(Item targetedItem) {
		Scanner scan = new Scanner(System.in);
		int input = -1;
		while(true) {
			try {
				System.out.print("Input time for " + targetedItem.getName() + ": ");
				input = scan.nextInt();
				if(isValidTimeFormat(input)) {
					break;
				} else {
					throw new InvalidDataFormatException();
				}
			} catch (InvalidDataFormatException e) {
				System.out.println("Invalid date format, please input again.");
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please input again.");
			}
		}
		
		targetedItem.setValue(input);
	}

}
