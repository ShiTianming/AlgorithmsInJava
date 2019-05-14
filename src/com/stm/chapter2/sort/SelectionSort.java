package com.stm.chapter2.sort;

import java.util.Arrays;

/**
 * Author STM
 * Create 5/14/19 2:47 PM
 */
public class SelectionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        Integer[] nums = {1, 6, 2, 4, 7, 9, 8, 10};
        sort.sort(nums);
        System.out.println(Arrays.asList(nums));

    }

}
