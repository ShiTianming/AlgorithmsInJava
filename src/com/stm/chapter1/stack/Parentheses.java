package com.stm.chapter1.stack;

/**
 * Author STM
 * Create 4/8/19 10:09 PM
 */
public class Parentheses {
    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case LEFT_BRACE:
                case LEFT_PAREN:
                case LEFT_BRACKET:
                    stack.push(s.charAt(i));
                    break;
                case RIGHT_BRACE:
                    if (stack.isEmpty() || (stack.pop() != LEFT_BRACE)) return false;
                    break;
                case RIGHT_PAREN:
                    if (stack.isEmpty() || (stack.pop() != RIGHT_PAREN)) return false;
                    break;
                case RIGHT_BRACKET:
                    if (stack.isEmpty() || (stack.pop() != RIGHT_BRACKET)) return false;
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("[()]{}{[()()]()}"));
    }
}
