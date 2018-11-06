package com.hsbc;

import com.hsbc.cmb.RPN;
import com.hsbc.cmb.operators.Addition;
import com.hsbc.cmb.operators.Computable;
import com.hsbc.cmb.operators.Substraction;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;

public class RPNTest {

    private Map<String, Computable> operandMap = new HashMap<>();

    public RPNTest(){
        operandMap.put("+", new Addition());
        operandMap.put("-", new Substraction());
    }

    @Test
    public void calcShouldBeAbleToCalculateMultipleDigitNumbers() {
        assertThat(RPN.calculation("12 22 -",operandMap), is(equalTo(-10.0)));
    }

    @Test
    public void calculationMethodShouldBeAbleToCalculateSingleDigitNumbers() {
        assertThat(RPN.calculation("7 1 +",operandMap), is(equalTo(8.0)));
    }

    @Test
    public void calculationMethodShouldFailWhenWeGiveWrongComputation() {
        assertThat(RPN.calculation("2 2 +",operandMap), not(equalTo(7)));
    }
}
