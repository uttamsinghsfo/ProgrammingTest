package com.workday;

/**
* a specialized container of records optimized for efficient range queries
* on an attribute of the data.
*/

interface RangeContainer {

/**
* @return the Ids of all instances found in the container that
* have data value between fromValue and toValue with optional
* inclusivity. The ids should be returned in ascending order when retrieved
* using nextId().
*/
    /**
     *
     * @param fromValue low in range
     * @param toValue high in range
     * @param fromInclusive true/false include low in range
     * @param toInclusive true/false include high in range
     * @return Ids : iterator of indices
     */
    Ids findIdsInRange(long fromValue,
                   long toValue,
                   boolean fromInclusive,
                   boolean toInclusive);
}