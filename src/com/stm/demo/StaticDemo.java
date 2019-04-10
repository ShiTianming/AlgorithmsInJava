package com.stm.demo;

/**
 * Author STM
 * Create 3/27/19 12:18 AM
 */
public class StaticDemo {

    static {
        print();
    }

    private static void print() {
        System.out.println("call print func...");
    }

    private void test1() {
        System.out.println("test1 func...");
    }

    private void test2() {
        System.out.println("test2 func...");
    }

    private static void test03() {
        System.out.println("test3 func...");
    }

    public static void main(String[] args) {
//        StaticDemo demo1 = new StaticDemo();
//        demo1.test1();
//        StaticDemo demo2 = new StaticDemo();
//        demo2.test2();
        StaticDemo.test03();
    }
}
