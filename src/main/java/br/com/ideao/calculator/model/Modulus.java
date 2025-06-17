package br.com.ideao.calculator.model;

public class Modulus implements Operator {
    @Override
    public Double operation(Double... operands) {
        Double result = operands[0];
        for (int i = 1; i < operands.length; i++) {
            result %= operands[i];
        }
        return result;
    }
}
