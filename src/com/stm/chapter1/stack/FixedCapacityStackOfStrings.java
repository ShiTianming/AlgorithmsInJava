package com.stm.chapter1.stack;

import com.stm.common.util.ReadFileUtils;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author STM
 * Create 3/28/19 10:00 AM
 */
public class FixedCapacityStackOfStrings implements Iterable<String> {
    private String[] table;     // hold the items
    private int size;           // number of items in stack

    public FixedCapacityStackOfStrings(int capacity) {
        table = new String[capacity];
        size = 0;
    }

    public boolean isEmpty() {return size == 0;}

    public boolean isFull() {return size == table.length;}

    public void push(String item) {table[size++] = item;}

    public String pop() {return table[--size];}

    public String peek() {return table[size - 1];}

    public Iterator<String> iterator() { return new ReverseArrayIterator(); }

    private class ReverseArrayIterator implements Iterator<String> {
        private int i = size - 1;

        public boolean hasNext() {
            return i >= 0;
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            return table[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ReadFileUtils.ReadInputFile("data/chapter01/tobe.txt");
        int max = 15;
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(max);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (stack.isEmpty()) StdOut.println("BAD INPUT");
            else StdOut.print(stack.pop() + " ");
        }
        StdOut.println();

        StdOut.println("Left on stack:");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
