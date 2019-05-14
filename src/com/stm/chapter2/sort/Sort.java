package com.stm.chapter2.sort;

/**
 * Author STM
 * Create 5/14/19 2:42 PM
 */
public abstract class Sort<T extends Comparable<T>> {
    public abstract void sort(T[] nums);

    protected boolean less(T u, T v) {
        return u.compareTo(v) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
