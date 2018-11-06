package com.hsbc.cmb;

import com.hsbc.cmb.operators.Addition;
import com.hsbc.cmb.operators.Computable;
import com.hsbc.cmb.operators.Substraction;
import com.hsbc.cmb.printers.*;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static void main(String... args) {

        //build args as string eg. args: 12 3 / should be one string "12 3 /"
        StringBuilder builder = new StringBuilder();
        for (String str: args)
        {
            builder.append(str);
        }
        String expression = builder.toString();

        Map<String, Computable> operandMap = new HashMap<>();
        operandMap.put("+", new Addition());
        operandMap.put("-", new Substraction());

        Double result = RPN.calculation(expression,operandMap);

        //define way to print result - now it's console way
        Printer printer = new ToConsole();
        printer.print(result);
    }
}
