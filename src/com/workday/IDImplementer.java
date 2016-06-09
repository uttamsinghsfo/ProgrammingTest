package com.workday;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Ids implementation
 */
public class IDImplementer implements Ids {

	static short END_OF_IDS = -1;

    // Actual list that contains all indices
    List<Short> res = new ArrayList<>();

    // Iterator to be used in nextId()
    Iterator<Short> iter = null;

    /**
     * get nextId
     * @return short
     */
	public short nextId() {
		return iter.next();
	}

}

