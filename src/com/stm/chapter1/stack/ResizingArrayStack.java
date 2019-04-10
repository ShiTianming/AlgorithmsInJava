package com.stm.chapter1.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author STM
 * Create 3/29/19 10:37 AM
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public ResizingArrayStack() {
        table = (Item[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void resize(int capacity) {
        Item[] tmp = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = table[i];
        }
        table = tmp;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void push(Item item) {
        if (size == table.length) resize(table.length << 1);
        table[size++] = item;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        return table[--size];
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("stack underflow");
        return table[size - 1];
    }

    @Override
    public Iterator<Item> iterator() {
        return new reverseArrayStack();
    }

    private class reverseArrayStack implements Iterator<Item> {

        private int n = size - 1;

        @Override
        public boolean hasNext() {
            return n >= 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("stack underflow");
            return table[n--];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();
        for (int i = 0; i < 15; i++) {
            stack.push("item" + i);
        }
        for (String i : stack) System.out.print(i + " ");
        System.out.println();
        for (int j = 15; j < 20; j++) {
            stack.push("item" + j);
        }
        for (String i : stack) System.out.print(i + " ");
    }
}
