package com.workday;

import java.util.Collections;

/**
 * Array implementation of RangeContainer interface
 */
public class ArrayRangeContainer implements RangeContainer {

    long[] sorteddata;
    short[] indices;

    /**
     * findIdsInRange : returns Ids for a given range of numbers with inclusive flags on both boundaries
     * @param fromValue  left in range
     * @param toValue  right in range
     * @param fromInclusive  include left in range (true/false)
     * @param toInclusive  include right in range (true/false)
     * @return Ids iterator of indices
     */
    public Ids findIdsInRange(long fromValue, long toValue, boolean fromInclusive, boolean toInclusive) {

        IDImplementer ids = new IDImplementer();

        // inclusive taken care
        if(!fromInclusive)
            fromValue++;
        if(!toInclusive)
            toValue--;

        // using binary search ; find left index in the sorted array for left boundary
        int index_left = binarySearchLow(fromValue);
        // using binary search ; find right index in the sorted array for right boundary
        int index_right = binarySearchHigh(toValue);

        // parse between left and right index to get ids 'indices'
        for (int i = index_left ; i <= index_right; ++i) {
            ids.res.add(indices[i]);
        }
        // sort indices
        Collections.sort(ids.res);

        // add END_OF_IDS to the end of result
        ids.res.add(ids.END_OF_IDS);

        // iterator to get nextId()
        ids.iter = ids.res.iterator();

        return ids;
    }

    /**
     * Binary Search for the lower value in the range query
     * @param fromValue low in range query
     * @return int index for first element greater or equal to the target number
     */
    int binarySearchLow(long fromValue) {
        if (sorteddata[sorteddata.length-1] < fromValue)
            return -1;
        int low = 0;
        int high = sorteddata.length - 1;
        while (low <= high) {
            int mid = low + ((high-low)/2);
            if(sorteddata[mid] >= fromValue)
                high = mid-1;
            else
                low = mid+1;
        }
        return high+1;
    }

    /**
     * Binary Search for the higher value in the range query
     * @param toValue high in range query
     * @return int index for first element lesser or equal to the target number
     */
    int binarySearchHigh(long toValue) {
        if (sorteddata[0] > toValue)
            return -1;
        int low = 0;
        int high = sorteddata.length-1;
        while (low<=high) {
            int mid = low+((high-low)/2);
            if(sorteddata[mid] > toValue)
                high = mid-1;
            else
                low = mid+1;
        }
        return low-1;
    }

}
