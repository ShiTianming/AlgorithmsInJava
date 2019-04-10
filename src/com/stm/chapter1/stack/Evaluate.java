package com.stm.chapter1.stack;

import com.stm.common.util.ReadFileUtils;
import edu.princeton.cs.algs4.StdIn;

/**
 * Author STM
 * Create 3/30/19 8:35 PM
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        ReadFileUtils.ReadInputFile("data/chapter01/evaluate.txt");
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "sqrt":
                    ops.push(s);
                    break;
                case ")":
                    String op = ops.pop();
                    double v = vals.pop();
                    switch (op) {
                        case "+":
                            v = vals.pop() + v;
                            break;
                        case "-":
                            v = vals.pop() - v;
                            break;
                        case "*":
                            v = vals.pop() * v;
                            break;
                        case "/":
                            assert v != 0d;
                            v = vals.pop() / v;
                            break;
                        case "sqrt":
                            v = Math.sqrt(v);
                            break;
                    }
                    vals.push(v);
                    break;
                default:
                    vals.push(Double.parseDouble(s));
            }
//            if (s.equals("(")) {
//            } else if (s.equals("+")) ops.push(s);
//            else if (s.equals("-")) ops.push(s);
//            else if (s.equals("*")) ops.push(s);
//            else if (s.equals("/")) ops.push(s);
//            else if (s.equals("sqrt")) ops.push(s);
//            else if (s.equals(")")) {
//                String op = ops.pop();
//                double v = vals.pop();
//                switch (op) {
//                    case "+":
//                        v = vals.pop() + v;
//                        break;
//                    case "-":
//                        v = vals.pop() - v;
//                        break;
//                    case "*":
//                        v = vals.pop() * v;
//                        break;
//                    case "/":
//                        assert v != 0d;
//                        v = vals.pop() / v;
//                        break;
//                    case "sqrt":
//                        v = Math.sqrt(v);
//                        break;
//                }
//                vals.push(v);
//            } else {
//                vals.push(Double.parseDouble(s));
//            }
        }
        System.out.println("result: " + vals.pop());
    }
}
