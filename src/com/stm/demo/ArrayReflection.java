package com.stm.demo;

import java.lang.reflect.Array;

/**
 * Author STM
 * Create 3/29/19 2:13 PM
 * <p>
 * 数组泛型转换是不允许的
 * 报错: Item[] items = new Item[length];
 * 正确: Item[] items = (Item[]) new Object[length];
 * 或者使用数组反射
 */
public class ArrayReflection<Item> {
    private Item[] arrayOf(Class<Item[]> clazz, int length) {
        return clazz.cast(Array.newInstance(clazz.getComponentType(), length));
    }

    public static void main(String[] args) {
        String[] strs = new ArrayReflection<String>().arrayOf(String[].class, 10);
        strs[0] = "hello";
        strs[1] = "world";
        System.out.println("length: " + strs.length + ", str[1]: " + strs[1]);
        Integer[] ints = new ArrayReflection<Integer>().arrayOf(Integer[].class, 10);
        ints[0] = 10;
        ints[1] = 11;
        System.out.println("length: " + ints.length + ", ints[1]: " + ints[1]);
    }
}
