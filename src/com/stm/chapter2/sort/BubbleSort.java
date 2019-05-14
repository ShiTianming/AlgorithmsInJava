package com.stm.chapter2.sort;

import java.util.Arrays;

/**
 * Author STM
 * Create 5/14/19 3:05 PM
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        boolean isSorted = false;
        for (int i = nums.length - 1; i >= 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    isSorted = false;
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        Integer[] nums = {1, 6, 2, 4, 7, 9, 8, 10};
        sort.sort(nums);
        System.out.println(Arrays.asList(nums));

    }
}
