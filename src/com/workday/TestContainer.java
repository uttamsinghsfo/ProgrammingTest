package com.workday;

import static junit.framework.Assert.assertEquals;

/**
 * Test Class
 */
public class TestContainer {

    private RangeContainer rc;

    /**
     * main method for test
     * @param args arguments
     */
    public static void main(String[] args) {
        TestContainer test = new TestContainer();
        test.setUp();
        test.runARangeQuery();
    }

    /**
     * set up; run createContainer
     */
    public void setUp() {
        RangeContainerFactory rf = new ArrayRangeContainerFactory();
        rc = rf.createContainer(new long[]{10,12,17,21,2,15,16});
    }

    /**
     * Actual test method
     */
    public void runARangeQuery() {
        Ids ids = rc.findIdsInRange(14, 17, true, true);
        assertEquals(2, ids.nextId());
        assertEquals(5, ids.nextId());
        assertEquals(6, ids.nextId());
        assertEquals(Ids.END_OF_IDS, ids.nextId());
        System.out.println("Test 1 (true, true) passed !!");

        ids = rc.findIdsInRange(20, Long.MAX_VALUE, false, true);
        assertEquals(3, ids.nextId());
        assertEquals(Ids.END_OF_IDS, ids.nextId());
        System.out.println("Test 2 (false, true with maxvalue) passed !!");

        ids = rc.findIdsInRange(14, 17, true, false);
        assertEquals(5, ids.nextId());
        assertEquals(6, ids.nextId());
        assertEquals(Ids.END_OF_IDS, ids.nextId());
        System.out.println("Test 3 (true, false) passed !!");

        System.out.println("ALL TEST PASSED !!");
    }
}

