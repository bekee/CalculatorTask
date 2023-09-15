package com.tasks;

public class ProcesResult extends Execution implements CalculatorInterterface {

	private String operations[];

	public ProcesResult(String question) {
		this.validateQueryInput(question);
	}


	@Override
	public double executeCalculator() {
		double result = 0;
		char operator = 0;

		String[] tokens =  this.getQuestionTokens();
		
		char captureFirstToken = tokens[0].charAt(0);
		
		// Check if first operator is minus
		if (captureFirstToken == '-') {
			
			// Replace with a signed integer
			tokens[1] = String.valueOf(Integer.parseInt(tokens[1]) * (-1));

			int indexToDelete = 0;

			if (indexToDelete >= 0 && indexToDelete < tokens.length) {
				// Create a new array with one less element
				String[] updatedToken = new String[tokens.length - 1];

				// Copy elements before the deleted index
				for (int i = 0; i < indexToDelete; i++) {
					updatedToken[i] = tokens[i];
				}

				// Copy elements after the deleted index
				for (int i = indexToDelete + 1; i < tokens.length; i++) {
					updatedToken[i - 1] = tokens[i];
				}

				// Now, updatedNames contains the "deleted" element removed
				tokens = updatedToken;
			}
		}

		// Limit the operation to max of 3 operands
		if (tokens.length > 5) {
			throw new ArithmeticException("Operation limited to 3 operands, eg. a*b-c");
		}

		// Compute the operation
		for (int i = 0; i < tokens.length; i++) {

			if (i == 0) {
				result = Integer.parseInt(tokens[i]);
				continue;
			}

			char checker = tokens[i].charAt(0);

			if (Character.isDigit(checker)) {
				if (operator != 0)
					result = this.runCalculation(result, Integer.parseInt(tokens[i]), operator);
			} else {
				operator = checker;
			}
		}

		return result;

	}

	@Override
	public void validateQueryInput(String question) {

		String[] extractTokens = question.replaceAll("\\s+", "").split("(?=[-+*/])|(?<=[-+*/])");

		for (String token : extractTokens) {

			switch (token) {

				//Group the allowed operands to run
				case "+":
				case "-":
				case "*":
				case "/":
					break;
				default: {
	
					/**
					 * 	Confirm if the value is an Integer, else throw an error to be captured in the main class
					 * */
					Integer.parseInt(token);
					break;
				}

			}

		}
		this.setQuestionTokens(extractTokens);
	}

	public String[] getQuestionTokens() {
		return operations;
	}

	public void setQuestionTokens(String[] question) {
		this.operations = question;
	}

}
