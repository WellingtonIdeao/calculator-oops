package br.com.ideao.calculator.model;

import java.util.*;

public class Add implements Operator{

    @Override
    public Double operation(Double... operands) {
        Double sum = 0.0;
        for (Double num: operands) {
            sum += num ;
        }
        return sum;
    }
}
