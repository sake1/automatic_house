package prompts;

import java.util.InputMismatchException;
import java.util.Scanner;

import interfaces.PromptInput;
import utils.InvalidDataFormatException;
import utils.Item;

public class ThermometerPrompt implements PromptInput {

	private boolean isValidTemperatureDegree(int temp) {
		return -273 <= temp && temp <= 100;
	}
	
	public void promptInput(Item targetedItem) {
		Scanner scan = new Scanner(System.in);
		int input = -1;
		while(true) {
			try {
				System.out.print("Input temperature measured by " + targetedItem.getName() + ": ");
				input = scan.nextInt();
				if(isValidTemperatureDegree(input)) {
					break;
				} else {
					throw new InvalidDataFormatException();
				}
			} catch (InvalidDataFormatException e) {
				System.out.println("Temperature too high / too low, please input again.");
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please input again.");
			}
		}
		
		targetedItem.setValue(input);
	}
}
