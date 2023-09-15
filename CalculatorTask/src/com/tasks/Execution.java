package com.tasks;

public abstract class Execution {

	protected double runCalculation(double op1, double op2, char operator) {
		
		switch (operator) {
		case '*':
			return op1 * op2;
		case '/':
			if (op1 == 0) {
				throw new ArithmeticException("Division by zero is cannot be processed.");
			}
			return op1 / op2;
		case '+':
			return op1 + op2;
		case '-':
			return op1 - op2;
		default:
			throw new IllegalArgumentException("Invalid arithmetic operation" + operator);
		}
	}

}
