package com.suresh.util;

import com.suresh.codingchallenge.model.ZipCodeRange;
import org.junit.Test;

import com.suresh.codingchallenge.util.ZipCodeRangeUtil;
import org.junit.Assert;

/**
 * Unit tests for ZipCodeRangeUtil class.
 *
 * @author Suresh Pasupuleti
 *
 */

public class ZipCodeRangeUtilTest {

    /**
     * Test for flattening an string array of strings with a space as a delimiter.
     */
    @Test
    public void strings() {
        Assert.assertEquals("1 2 3 4", ZipCodeRangeUtil.join(new String[] {"1", "2", "3", "4"}, " "));
    }

    /**
     * Test for flattening an array of ZipCodeRange objects with a space as a delimiter.
     */
    @Test
    public void zipCodeRanges() {
        ZipCodeRange range1 = new ZipCodeRange(10000,10001);
        ZipCodeRange range2 = new ZipCodeRange(10002,10003);
        ZipCodeRange range3 = new ZipCodeRange(10004,10005);

        ZipCodeRange[] ranges = new ZipCodeRange[] { range1, range2, range3 };

        Assert.assertEquals("[10000,10001] [10002,10003] [10004,10005]", ZipCodeRangeUtil.join(ranges, " "));
    }
}
