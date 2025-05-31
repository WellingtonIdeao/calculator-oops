package br.com.ideao.calculator;

import br.com.ideao.calculator.model.Add;
import br.com.ideao.calculator.model.Operator;
import br.com.ideao.calculator.util.ReadInput;

import java.util.*;

/**
 * Hello world!
 */
public final class Calculator {

    private Calculator() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        String inputExpr = ReadInput.read();
        String[] numberArr = inputExpr.split("[-+*/%]");
        String[] operArr = inputExpr.split("\\d+");



        Queue<String> numbers = new LinkedList<>(Arrays.asList(numberArr));
        Queue<String> operators = new LinkedList<>(Arrays.asList(operArr));
        cleanCollection(numbers);
        cleanCollection(operators);

        Double result = Double.parseDouble(Objects.requireNonNull(numbers.poll()));

        Operator operator = null;
        while(!numbers.isEmpty()) {

               if(!operators.isEmpty()) {
                   String op = operators.poll();
                   switch (op) {
                       case "+":
                           operator = new Add();
                           break;
                       default:
                           break;

                   }

               }
               Double num = Double.parseDouble(Objects.requireNonNull(numbers.poll()));
               if (operator != null) {
                   result = operator.operation(result, num);
               }
        }
        System.out.println(result);

    }
    private static void  cleanCollection(Collection<String> list) {
        for(Iterator<String> iter = list.iterator(); iter.hasNext();) {
            String s = iter.next();
            if(s == null || s.isEmpty()) {
                iter.remove();
            }
        }
    }
}
