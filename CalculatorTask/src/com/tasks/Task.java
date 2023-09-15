package com.tasks;

import java.util.Scanner;

public class Task {

	public static void main(String[] args) {
		
		try {
			
			System.out.println("This is a basic calculator application");
			
			runCalculator();
			
		}
		catch(ArithmeticException e) {
			System.out.println("An invalid integer was entered: "+ e.getMessage());
		}
		catch (NumberFormatException e) {
			System.out.println("An invalid integer was entered: " + e.getMessage());
		}
		catch(IllegalArgumentException e) {
			System.out.println("Illegal arithimetic operations: "+ e.getMessage());
		}

		catch(Exception e) {
			System.out.println( e.getMessage());
		}
		
	}
	static void runCalculator() {
		Scanner scanner  = new Scanner(System.in);
		
		System.out.println("Please enter the arithmetic operation in formats like a+b-c, a*b+c, a-b-c, etc");
		System.out.print("Note: A maximum of 3 operands are allowed \n");
		
		// Collect a string input of the question
		String mainQuestion = scanner.nextLine();
		
		scanner.close();
		
		//Analyze the input and perform arithmetic operation
		
		int result =  (int)Math.floor( new ProcesResult(mainQuestion).executeCalculator());
		
		System.out.print("Final Result= "+result);
	}

}
