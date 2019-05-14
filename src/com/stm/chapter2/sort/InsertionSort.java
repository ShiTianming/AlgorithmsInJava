package com.stm.chapter2.sort;

import java.util.Arrays;

/**
 * Author STM
 * Create 5/14/19 3:54 PM
 */
public class InsertionSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        Integer[] nums = {1, 6, 2, 4, 7, 9, 8, 10};
        sort.sort(nums);
        System.out.println(Arrays.asList(nums));

    }
}
