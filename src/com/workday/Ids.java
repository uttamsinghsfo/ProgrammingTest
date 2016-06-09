package com.workday;

/**
* an iterator of Ids
*/

interface Ids {
/**
* return the next id in sequence, -1 if at end of data.
* The ids should be in sorted order (from lower to higher) to facilitate
* the query distribution into multiple containers.
*/

static final short END_OF_IDS = -1;

    /**
     * get nextId
     * @return short
     */
    short nextId();

}