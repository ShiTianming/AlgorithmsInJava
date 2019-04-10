package com.stm.chapter1.stack;

import com.stm.common.util.ReadFileUtils;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author STM
 * Create 3/28/19 11:08 PM
 */
public class FixedCapacityStack<Item> implements Iterable<Item> {

    private int size;
    private Item[] table;

    public FixedCapacityStack(int capacity) {
        size = 0;
//        table = new Item[capacity];
        // 数组泛型转换
        table = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == table.length;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        return table[--size];
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        return table[size - 1];
    }

    public void push(Item item) {
        if (isFull()) {
            System.out.println("stack overflow");
            return;
        }
        table[size++] = item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new reverseStackIterator();
    }

    private class reverseStackIterator implements Iterator<Item> {

        private int i = size - 1;

        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return table[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ReadFileUtils.ReadInputFile("data/chapter01/tobe.txt");
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(15);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!"-".equals(item)) {
                stack.push(item);
            } else if (stack.isEmpty()) StdOut.println("BAD INPUT");
            else StdOut.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
