package com.workday;

import java.util.Comparator;

/**
 * Custom Comparator to sort indices on sorted array
 */
public class ArrayIndexSort implements Comparator<Integer> {
    private final long[] array;

    /**
     * setter method
     * @param array input array
     */
    public ArrayIndexSort(long[] array) {
        this.array = array;
    }

    /**
     * create the index array from a given array
     * @return int[]
     */
    public Integer[] createIndexArray() {
        Integer[] indexes = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            indexes[i] = i;
        }
        return indexes;
    }

    /**
     * custom comparator to get indices of a sorted array
     * @param index1 pass first index
     * @param index2 pass second index
     * @return int
     */
    @Override
    public int compare(Integer index1, Integer index2) {
        if (array[index1] < array[index2]) {
            return -1;
        } else if (array[index1] > array[index2]) {
            return 1;
        }
        return 0;
    }
}