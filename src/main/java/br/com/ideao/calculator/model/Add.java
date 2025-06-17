package br.com.ideao.calculator.model;


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
