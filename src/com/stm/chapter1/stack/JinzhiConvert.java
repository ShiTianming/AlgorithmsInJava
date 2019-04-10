package com.stm.chapter1.stack;

/**
 * Author STM
 * Create 4/7/19 9:53 PM
 * <p>
 * 进制转换
 * 12345(10) = 30071(8)
 *      12345 % 8 = 1  12345 / 8 = 1543
 *      1543 % 8 = 7   1543 / 8 = 192
 *      192 % 8 = 0    192 / 8 = 24
 *      24 % 8 = 0     24 / 8 = 3
 *      3 % 8 = 3      3 / 8 = 0
 *
 * 12345(16) = 3039(16)
 *      12345 % 16 = 9  12345 / 16 = 771
 *      771 % 16 = 3    771 / 16 = 48
 *      48 % 16 = 0     48 / 16 = 3
 *      3 % 16 = 3      3 / 16 = 0
 */
public class JinzhiConvert {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        convert(stack, 12345, 8);
        System.out.println(stack);
        Stack<Character> stack1 = new Stack<>();
        convert2(stack1, 12345, 16);
        System.out.println(stack1);
    }

    /**
     * 进制转换
     * 递归实现
     *
     * @param stack 保存转换后的数字
     * @param n     原数字（十进制）
     * @param base  被转换的进制
     */
    private static void convert(Stack<Character> stack, int n, int base) {
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        if (n > 0) {
            stack.push(digits[n % base]);
            convert(stack, n / base, base);
        }
    }

    /**
     * 进制转换
     * 迭代实现
     *
     * @param stack 保存转换后的数字
     * @param n     原数字（十进制）
     * @param base  被转换的进制
     */
    private static void convert2(Stack<Character> stack, int n, int base) {
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (n > 0) {
            stack.push(digits[n % base]);
            n /= base;
        }
    }
}
