package com.stm.chapter1.stack;


import com.stm.common.util.ReadFileUtils;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author STM Create 3/27/19 10:38 PM
 */
public class Stack<Item> implements Iterable<Item> {

    private Node<Item> first;       // top of stack
    private int size;               // size of the stack

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty stack
     */
    public Stack() {
        first = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    /**
     * Adds the item to this stack
     *
     * @param item the item to add
     */
    public void push(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    /**
     * Removes and returns the item most recently added to this stack
     *
     * @return the item most recently added
     * @throws NoSuchElementException if the stack is empty
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack
     *
     * @return the item most recently added
     * @throws NoSuchElementException if the stack is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        /*
         * like
         * List<Integer> list = new ArrayList<Integer>();
         * for(Integer i: list) {...}
         */
        for (Item item : this) {
            s.append(item);
            s.append(" ");
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new ListIterator(first);
    }

    // an iterator
    private class ListIterator implements Iterator<Item> {

        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * tests
     */
    public static void main(String[] args) {

        // creates 'System.in'
        ReadFileUtils.ReadInputFile("data/chapter01/tobe.txt");

        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop()+" ");
            }
        }
        StdOut.println("(" + stack.size() + " left on stack)");
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (String s : stack) {
            System.out.println(s);
        }
    }
}
