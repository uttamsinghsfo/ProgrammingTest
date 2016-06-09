package com.workday;

import java.util.Arrays;

/**
 * Array implementation of RangeContainerFactory
 */
public class ArrayRangeContainerFactory implements RangeContainerFactory {

    /**
     * run this one time and save in-memory
     * create container for a given unsorted array
     * @param data input unsorted array
     * @return RangeContainer  sorteddata and corresponding indices
     */
    public RangeContainer createContainer(long[] data) {

    	ArrayRangeContainer rc = new ArrayRangeContainer();

        ArrayIndexSort comparator = new ArrayIndexSort(data);
        // create index array from given array
        Integer[] indexes = comparator.createIndexArray();
        // indoces for the sorted array
        Arrays.sort(indexes, comparator);
        // sort actual data
        Arrays.sort(data);

        // set values in RangeContainer
        rc.sorteddata = data;
        rc.indices = new short[indexes.length];
        // loop to get indices in short
        for (int i = 0 ; i < indexes.length; ++i) {
            rc.indices[i] = indexes[i].shortValue();
        }

        return rc;
    }

	
}
