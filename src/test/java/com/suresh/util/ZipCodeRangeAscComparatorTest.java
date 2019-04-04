package com.suresh.util;

import com.suresh.codingchallenge.model.ZipCodeRange;
import com.suresh.codingchallenge.util.ZipCodeRangeAscComparator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZipCodeRangeAscComparatorTest {

    /**
     * Test sorting of lowerBound followed by upperBound in ascending order
     */
    @Test
    public void sort() {

        ZipCodeRange range1 = new ZipCodeRange(90003, 10003);
        ZipCodeRange range2 = new ZipCodeRange(10000, 10004);
        ZipCodeRange range3 = new ZipCodeRange(10000, 10002);
        ZipCodeRange range4 = new ZipCodeRange(10000, 10001);
        ZipCodeRange range5 = new ZipCodeRange(10000, 10003);
        ZipCodeRange range6 = new ZipCodeRange(20000, 30003);

        List<ZipCodeRange> ranges = new ArrayList<>();

        ranges.add(range1);
        ranges.add(range2);
        ranges.add(range3);
        ranges.add(range4);
        ranges.add(range5);
        ranges.add(range6);

        Collections.sort(ranges, new ZipCodeRangeAscComparator());

        Assert.assertEquals(10000, ranges.get(0).getLowerBound());
        Assert.assertEquals(10001, ranges.get(0).getUpperBound());
        Assert.assertEquals(10000, ranges.get(1).getLowerBound());
        Assert.assertEquals(10002, ranges.get(1).getUpperBound());
        Assert.assertEquals(10000, ranges.get(2).getLowerBound());
        Assert.assertEquals(10003, ranges.get(2).getUpperBound());
        Assert.assertEquals(10000, ranges.get(3).getLowerBound());
        Assert.assertEquals(10004, ranges.get(3).getUpperBound());
        Assert.assertEquals(20000, ranges.get(4).getLowerBound());
        Assert.assertEquals(30003, ranges.get(4).getUpperBound());
        Assert.assertEquals(90003, ranges.get(5).getLowerBound());
        Assert.assertEquals(10003, ranges.get(5).getUpperBound());
    }
}
