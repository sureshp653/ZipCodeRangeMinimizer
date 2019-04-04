package com.suresh.Service;

import com.suresh.codingchallenge.model.ZipCodeRange;
import com.suresh.codingchallenge.service.ZipCodeRangeMinimizer;
import com.suresh.codingchallenge.util.ZipCodeRangeUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Various test cases for the ZipCode Range Minimizer Service class.
 *
 * @author Suresh Pasupuleti
 *
 */

public class ZipCodeRangeMinimizerServiceTest {

    /**
     * Test case 1:
     *
     * No overlapping ranges
     *
     * Input: [94133,94133] [94200,94299] [94600,94699]
     * Expected: [94133,94133] [94200,94299] [94600,94699]
     */
    @Test
    public void case1() {
        ZipCodeRange[] newRanges = ZipCodeRangeMinimizer.minimizeZipCodeRanges(new String[]{
                "[94133,94133]", "[94200,94299]", "[94600,94699]"
        });
        Assert.assertEquals("[94133,94133] [94200,94299] [94600,94699]", ZipCodeRangeUtil.join(newRanges, " "));
    }

    /**
     * Test case 2:
     *
     * One overlapping range
     *
     * Input: [94133,94133] [94200,94299] [94226,94399]
     * Expected: [94133,94133] [94200,94399]
     */
    @Test
    public void case2() {
        ZipCodeRange[] newRanges = ZipCodeRangeMinimizer.minimizeZipCodeRanges(new String[]{
                "[94133,94133]", "[94200,94299]", "[94226,94399]"
        });
        Assert.assertEquals("[94133,94133] [94200,94399]", ZipCodeRangeUtil.join(newRanges, " "));
    }

    /**
     * Test case 3:
     *
     * All the same ranges
     *
     * Input: [11111,11111] [11111,11111] [11111,1111]
     * Expected: [11111,11111]
     */
    @Test
    public void case3() {
        ZipCodeRange[] newRanges = ZipCodeRangeMinimizer.minimizeZipCodeRanges(new String[]{
                "[11111,11111]", "[11111,11111]", "[11111,11111]"
        });
        Assert.assertEquals("[11111,11111]", ZipCodeRangeUtil.join(newRanges, " "));
    }

    /**
     * Test case 4:
     *
     * All ranges get swallowed up by one range
     *
     * Input: [11111,11111] [11112,11113] [11111,11111] [11117,11118] [11110,11119] [10000,20000]
     * Expected: [10000,20000]
     */
    @Test
    public void case4() {
        ZipCodeRange[] newRanges = ZipCodeRangeMinimizer.minimizeZipCodeRanges(new String[]{
                "[11111,11111]", "[11112,11113]", "[11111,11111]", "[11117,11118]", "[11110,11119]", "[10000,20000]"
        });
        Assert.assertEquals("[10000,20000]", ZipCodeRangeUtil.join(newRanges, " "));
    }

    /**
     * Test case 5:
     *
     * Specify some ranges backwards
     *
     * Input: [31111,11111] [11111,31111] [11110,11111] [11117,10000] [11110,11119] [32110,33112]
     * Expected: [11111,31111] [32110,33112]
     */
    @Test
    public void case5() {
        ZipCodeRange[] newRanges = ZipCodeRangeMinimizer.minimizeZipCodeRanges(new String[]{
                "[31111,11111]", "[11111,31111]", "[11110,11111]", "[11117,10000]", "[11110,11119]", "[32110,33112]"
        });
        Assert.assertEquals("[10000,31111] [32110,33112]", ZipCodeRangeUtil.join(newRanges, " "));
    }
}
