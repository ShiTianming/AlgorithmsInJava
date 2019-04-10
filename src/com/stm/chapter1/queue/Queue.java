package com.stm.chapter1.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Author STM
 * Create 3/30/19 11:02 PM
 */
public class Queue<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("queue underflow");
        Item item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) last = null;
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("queue underflow");
        return first.item;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator<Item>(first);
    }

    private class QueueIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        public QueueIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("queue underflow");
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item.toString()).append(" ");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        for (int i = 0; i < 1; i++) {
            queue.enqueue("item" + i);
        }
        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue.toString());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue.toString());
        System.out.println(queue.peek());
    }
}
