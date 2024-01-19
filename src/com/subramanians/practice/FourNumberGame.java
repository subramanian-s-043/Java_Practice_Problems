package com.subramanians.practice;
import java.util.ArrayList;
import java.util.List;

public class FourNumberGame {

	public static void main(String[] args) {
        List<Integer> digits = List.of(2,5,7,8);
        
        List<String> allCombinations = generateAllCombinations(digits);

        for (String combination : allCombinations) {
            System.out.println(combination);
        }
    }

    private static List<String> generateAllCombinations(List<Integer> digits) {
        List<String> result = new ArrayList<>();
        permuteOperators(result, digits, new ArrayList<>(), 0);
        return result;
    }

    private static void permuteOperators(List<String> result, List<Integer> digits, List<String> operators, int index) {
        if (index == digits.size() - 1) {
            result.add(buildExpression(digits, operators));
        } else {
            for (String operator : List.of("+", "-", "*", "/")) {
                operators.add(operator);
                permuteOperators(result, digits, operators, index + 1);
                operators.remove(operators.size() - 1);
            }
        }
    }

    private static String buildExpression(List<Integer> digits, List<String> operators) {
        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < digits.size() - 1; i++) {
            expression.append(digits.get(i)).append(" ").append(operators.get(i)).append(" ");
        }
        expression.append(digits.get(digits.size() - 1));
        //evaluate expression
        return expression.toString();
    }
}
