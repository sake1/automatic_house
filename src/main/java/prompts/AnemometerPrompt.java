package prompts;

import java.util.InputMismatchException;
import java.util.Scanner;

import interfaces.PromptInput;
import utils.InvalidDataFormatException;
import utils.Item;

public class AnemometerPrompt implements PromptInput {

	private boolean isValidBeaufortScale(int speed) {
		return 0 <= speed && speed <= 12; 
	}
	
	public void promptInput(Item targetedItem) {
		Scanner scan = new Scanner(System.in);
		int input = -1;
		while(true) {
			try {
				System.out.print("Input Beaufort scale measured by " + targetedItem.getName() + "[0-12]: ");
				input = scan.nextInt();
				if(isValidBeaufortScale(input)) {
					break;
				} else {
					throw new InvalidDataFormatException();
				}
			} catch (InvalidDataFormatException e) {
				System.out.println("Invalid Beaufort scale measure value [0-12], please input again.");
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please input again.");
			}
		}
		
		targetedItem.setValue(input);
	}
}
