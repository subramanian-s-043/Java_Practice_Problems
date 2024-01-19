package com.subramanians.practice;

import java.util.ArrayList;

public class GPT {

	    public static void main(String[] args) {
	        int[] numbers = {2, 5, 7, 8};
	        int targetResult = 103;

	        generateExpressions(numbers, targetResult, "", 0);
	    }

	    public static void generateExpressions(int[] numbers, int targetResult, String currentExpression, int index) {
	        if (index == numbers.length) {
	            if (evaluateExpression(currentExpression) == targetResult) {
	                System.out.println("Expression: " + currentExpression + " = " + targetResult);
	                System.exit(0); // Stop further exploration after finding one valid expression
	            }
	            return;
	        }
	        generateExpressions(numbers, targetResult, currentExpression + numbers[index], index + 1);
	        generateExpressions(numbers, targetResult, currentExpression + "+" + numbers[index], index + 1);
	        generateExpressions(numbers, targetResult, currentExpression + "-" + numbers[index], index + 1);
	        generateExpressions(numbers, targetResult, currentExpression + "*" + numbers[index], index + 1);
	        generateExpressions(numbers, targetResult, currentExpression + "/" + numbers[index], index + 1);
	    }

	    public static int evaluateExpression(String expression) {
	        // Split the expression into numbers and operators
	        String[] tokens = expression.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");

	        // Initialize result with the first number
	        int result = Integer.parseInt(tokens[0]);

	        // Loop through the tokens and apply operators
	        for (int i = 1; i < tokens.length-1; i += 2) {
	            String operator = tokens[i];
	            int operand = Integer.parseInt(tokens[i + 1]);

	            switch (operator) {
	                case "+":
	                    result += operand;
	                    break;
	                case "-":
	                    result -= operand;
	                    break;
	                case "*":
	                    result *= operand;
	                    break;
	                case "/":
	                    result /= operand;
	                    break;
	            }
	        }

	        return result;
	    }
	}

/* Two digit Combinations
     public static void main(String[] args) {
        int[] digits = {2, 5, 7, 8};

        // Step 1: Generate all possible two-digit numbers
        ArrayList<String> twoDigitNumbers = generateTwoDigitNumbers(digits);

        System.out.println("All possible two-digit numbers:");
        for (String number : twoDigitNumbers) {
            System.out.print(number + " ");
        }
        System.out.println("\n");

        // Step 2: Find all operation combinations for two-digit numbers
        System.out.println("All operation combinations for two-digit numbers:");
        findOperationCombinations(twoDigitNumbers);

        // Step 3: Generate all possible three-digit numbers
        ArrayList<String> threeDigitNumbers = generateCombinations(digits);

        System.out.println("\nAll possible three-digit numbers:");
        for (String combination : threeDigitNumbers) {
            System.out.println(combination);
        }

        // Step 4: Find all operation combinations for three-digit numbers
        System.out.println("\nAddition, Subtraction, Multiplication, and Division results for three-digit numbers:");
        performOperations(threeDigitNumbers, digits);
    }

    private static ArrayList<String> generateTwoDigitNumbers(int[] digits) {
        ArrayList<String> twoDigitNumbers = new ArrayList<>();

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (i != j) {
                    String number = "" + digits[i] + digits[j];
                    twoDigitNumbers.add(number);
                }
            }
        }

        return twoDigitNumbers;
    }

    private static ArrayList<String> generateCombinations(int[] digits) {
        ArrayList<String> combinations = new ArrayList<>();
        generateCombinationsHelper(digits, "", combinations);
        return combinations;
    }

    private static void generateCombinationsHelper(int[] digits, String current, ArrayList<String> combinations) {
        if (current.length() == digits.length - 1) {
            combinations.add(current);
            return;
        }

        for (int digit : digits) {
            if (current.indexOf(Character.forDigit(digit, 10)) == -1) {
                generateCombinationsHelper(digits, current + digit, combinations);
            }
        }
    }

    private static void findOperationCombinations(ArrayList<String> twoDigitNumbers) {
        for (int i = 0; i < twoDigitNumbers.size(); i++) {
            for (int j = 0; j < twoDigitNumbers.size(); j++) {
                if (i != j) {
                    int operand1 = Integer.parseInt(twoDigitNumbers.get(i));
                    int operand2 = Integer.parseInt(twoDigitNumbers.get(j));

                    // Multiplication
                    int product = operand1 * operand2;
                    System.out.println(twoDigitNumbers.get(i) + " * " + twoDigitNumbers.get(j) + " = " + product);

                    // Division (avoid division by zero)
                    if (operand2 != 0) {
                        double quotient = (double) operand1 / operand2;
                        System.out.println(twoDigitNumbers.get(i) + " / " + twoDigitNumbers.get(j) + " = " + quotient);
                    }

                    // Addition
                    int sum = operand1 + operand2;
                    System.out.println(twoDigitNumbers.get(i) + " + " + twoDigitNumbers.get(j) + " = " + sum);

                    // Subtraction
                    int diff = operand1 - operand2;
                    System.out.println(twoDigitNumbers.get(i) + " - " + twoDigitNumbers.get(j) + " = " + diff);

                    System.out.println();  // Separate each set of operations
                }
            }
        }
    }

    private static void performOperations(ArrayList<String> combinations, int[] digits) {
        for (String combination : combinations) {
            int remainingDigit = getRemainingDigit(digits, combination);
            double result = 0;

            // Multiplication
            result = Integer.parseInt(combination) * remainingDigit;
            System.out.println(combination + " * " + remainingDigit + " = " + result);

            // Division (avoid division by zero)
            if (remainingDigit != 0) {
                result = (double) Integer.parseInt(combination) / remainingDigit;
                System.out.println(combination + " / " + remainingDigit + " = " + result);
            } else {
                System.out.println(combination + " / " + remainingDigit + " = Undefined (Division by zero)");
            }

            // Addition
            result = Integer.parseInt(combination) + remainingDigit;
            System.out.println(combination + " + " + remainingDigit + " = " + result);

            // Subtraction
            result = Integer.parseInt(combination) - remainingDigit;
            System.out.println(combination + " - " + remainingDigit + " = " + result);

            System.out.println();  // Separate each set of operations
        }
    }

    private static int getRemainingDigit(int[] digits, String combination) {
        for (int digit : digits) {
            if (combination.indexOf(Character.forDigit(digit, 10)) == -1) {
                return digit;
            }
        }
        return -1; // This should not happen if the logic is correct
    }
 */