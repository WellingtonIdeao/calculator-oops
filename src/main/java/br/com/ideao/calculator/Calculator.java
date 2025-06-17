package br.com.ideao.calculator;

import br.com.ideao.calculator.model.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String inputExpr;
        Pattern pattern = Pattern.compile("^[-+]?[0-9]+[-+*/%][0-9]+([-+*/%][0-9]+)*$");
        Matcher matcher;
        try(Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("digite uma expressão matematica: ex: 1+3");
                inputExpr = sc.nextLine();
                matcher = pattern.matcher(inputExpr);
            } while(!matcher.matches());
        }

        String[] numberArr = inputExpr.split("[-+*/%]");
        String[] operArr = inputExpr.split("\\d+");

        Queue<String> numbers = new LinkedList<>(Arrays.asList(numberArr));
        Queue<String> operators = new LinkedList<>(Arrays.asList(operArr));
        cleanCollection(numbers);
        cleanCollection(operators);

        Double result = Double.parseDouble(Objects.requireNonNull(numbers.poll()));

        while(!numbers.isEmpty()) {
            String opr = operators.poll();
            Operator oprObj;

            switch (Objects.requireNonNull(opr)) {
                case "+":
                    oprObj = new Add();
                    break;
                case "-":
                    oprObj = new Sub();
                    break;
                case "*":
                    oprObj = new Multiply();
                    break;
                case "/":
                    oprObj = new Divide();
                    break;
                case "%":
                    oprObj = new Modulus();
                    break;
                default:
                    continue;
            }

            Double num = Double.parseDouble(Objects.requireNonNull(numbers.poll()));
            result = oprObj.operation(result, num);
        }

        System.out.println(inputExpr + " = " +result);
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
