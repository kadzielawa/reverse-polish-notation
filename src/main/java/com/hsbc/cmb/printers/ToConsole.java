package com.hsbc.cmb.printers;

public class ToConsole extends Printer {

    @Override
    public void print(Double result) {
        System.out.println("Result: "+ result);
    }
}
