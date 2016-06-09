package com.workday;

interface RangeContainerFactory {

/**
* builds an immutable container optimized for range queries.
* Data is expected to be 32k items or less.
* The position in the data array represents the id for that instance
* in question. For the PayrollResult example before, the id might be
* the workers employee number, the data value is the corresponding
* net pay. E.g, data[5]=2000 means that employee #6 has net pay of 2000.
*/

    /**
     * create container to save in-memory
     * @param data input data
     * @return RangeContainer in-memory container
     */
    RangeContainer createContainer(long[] data);

}
