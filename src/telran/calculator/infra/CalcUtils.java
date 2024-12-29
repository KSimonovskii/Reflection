package telran.calculator.infra;

import telran.calculator.model.Calculator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CalcUtils {

    public static Double getResultOfCalc(String action, double... args){

        Class<Calculator> clazz = Calculator.class;

        try {
            Constructor<Calculator> calc = clazz.getConstructor();
            Class[] paramsType = {double.class, double.class};
            Method method = clazz.getDeclaredMethod(action, paramsType);
            Object obj = method.invoke(calc.newInstance(), args[0], args[1]);
            return (Double) obj;
        } catch (Exception e) {

            String msg = "";

            if (e instanceof NoSuchMethodException) {
                msg = "Error: action '" + action + "' not possible in calculator";
            } else if (e instanceof IllegalArgumentException) {
                msg = "Error: incorrect input parameters ('" + args[1] + "', '" + args[2] + "')";
            } else {
                msg = e.getMessage();
            }
            System.out.println(msg);
            return null;
        }
    }


}
