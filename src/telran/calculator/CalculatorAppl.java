package telran.calculator;

import telran.calculator.infra.CalcUtils;

public class CalculatorAppl {
    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("Error: incorrect input parameters");
            return;
        }

        Double res = CalcUtils.getResultOfCalc(args[0], Double.parseDouble(args[1]), Double.parseDouble(args[2]));

        if (res == null){
            return;
        }

        StringBuilder sb = new StringBuilder("Result of action '")
                .append(args[0])
                .append("' for numbers ")
                .append(args[1])
                .append(" & ")
                .append(args[2])
                .append(" = ")
                .append(res);
        System.out.println(sb);
    }

}
