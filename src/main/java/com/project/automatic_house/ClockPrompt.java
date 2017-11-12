package com.project.automatic_house;

import java.util.InputMismatchException;
import java.util.Scanner;

import interfaces.PromptInput;

public class ClockPrompt implements PromptInput {

	private boolean isValidTimeFormat(int time) {
		return time >= 0 && time < 2400 && time % 100 < 60; 
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
