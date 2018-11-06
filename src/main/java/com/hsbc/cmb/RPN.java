package com.hsbc.cmb;

import com.hsbc.cmb.operators.Computable;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.function.*;

import static java.lang.System.exit;

public class RPN {

    public static Double calculation(String expression,Map<String, Computable> operandMap) {

        Stack<Double> numbers = new Stack<>();
        Arrays.asList(expression.split(" ")).stream().forEach(number -> {

            try {
                if (operandMap.containsKey(number)) {
                    calculateOperand(numbers, (x1, x2) -> operandMap.get(number).computation(x1, x2));
                } else {
                    numbers.push(Double.parseDouble(number));
                }
            } catch (NumberFormatException e){
                System.out.println("Operator '" + number +"' couldn't be recognized!");
                exit(0);
            }

        });
        return numbers.pop();
    }

    private static Stack<Double> calculateOperand(Stack<Double> numbers, BiFunction<Double, Double, Double> calculation) {
        numbers.push(calculation.apply(numbers.pop(), numbers.pop()));
        return numbers;
    }

}