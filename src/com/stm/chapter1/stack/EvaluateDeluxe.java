package com.stm.chapter1.stack;

import com.stm.common.util.ReadFileUtils;
import edu.princeton.cs.algs4.StdIn;

import java.util.HashMap;
import java.util.Map;

/**
 * Author STM
 * Create 4/10/19 11:49 AM
 */
public class EvaluateDeluxe {

    private static double eval(String op, double val1, double val2) {
        if ("-".equals(op)) return val1 - val2;
        if ("+".equals(op)) return val1 + val2;
        if ("*".equals(op)) return val1 * val2;
        if ("/".equals(op)) return val1 / val2;
        throw new RuntimeException("Invalid operator");
    }

    private static Map<String, Integer> getPrecedence() {
        Map<String, Integer> map = new HashMap<>();
        map.put("(", 0);
        map.put(")", 0);
        map.put("+", 1);
        map.put("-", 1);
        map.put("*", 2);
        map.put("/", 2);
        return map;
    }

    public static void main(String[] args) {
        Stack<Double> vals = new Stack<>();
        Stack<String> ops = new Stack<>();

        ReadFileUtils.ReadInputFile("data/chapter01/evaluateDeluxe.txt");

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if (!getPrecedence().containsKey(s)) {
                vals.push(Double.parseDouble(s));
                continue;
            }

            while (true) {
                if (ops.isEmpty() || s.equals("(") || (getPrecedence().get(s) > getPrecedence().get(ops.peek()))) {
                    ops.push(s);
                    break;
                }
                String op = ops.pop();

                if ("(".equals(op)) {
                    assert (")".equals(s));
                    break;
                } else {
                    double val2 = vals.pop();
                    double val1 = vals.pop();
                    vals.push(eval(op, val1, val2));
                }
            }
        }

        while (!ops.isEmpty()) {
            String op = ops.pop();
            double val2 = vals.pop();
            double val1 = vals.pop();
            vals.push(eval(op, val1, val2));
        }

        System.out.println(vals.pop());
        assert vals.isEmpty();
        assert ops.isEmpty();
    }
}
