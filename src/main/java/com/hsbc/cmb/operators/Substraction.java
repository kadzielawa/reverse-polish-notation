package com.hsbc.cmb.operators;

public class Substraction  implements Computable {

    @Override
    public double computation(Double x1, Double x2) {
        return x2 - x1;
    }
}
