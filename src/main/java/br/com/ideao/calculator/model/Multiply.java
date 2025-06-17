package br.com.ideao.calculator.model;

public class Multiply implements Operator {
    @Override
    public Double operation(Double... operands) {
        Double result = 1.0;
        for (Double num: operands) {
            result *= num;
        }
        return result;
    }
}
