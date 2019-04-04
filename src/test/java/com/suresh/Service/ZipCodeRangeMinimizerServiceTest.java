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
    public void noOverlappingZipCodeRanges() {
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
    public void overLappingZipCodeRanges() {
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
     * Input: [99999,99999] [99999,99999] [99999,99999]
     * Expected: [99999,99999]
     */
    @Test
    public void equalZipCodeRanges() {
        ZipCodeRange[] newRanges = ZipCodeRangeMinimizer.minimizeZipCodeRanges(new String[]{
                "[99999,99999]", "[99999,99999]", "[99999,99999]"
        });
        Assert.assertEquals("[99999,99999]", ZipCodeRangeUtil.join(newRanges, " "));
    }

    /**
     * Test case 4:
     *
     * All ranges get swallowed up by one range
     *
     * Input: [61111,61111], [61112,61113], [61111,61111], [61117,61118], [61110,61119], [60000,70000]
     * Expected: [60000,70000]
     */
    @Test
    public void swalloZipCodeRangesByOneRange() {
        ZipCodeRange[] newRanges = ZipCodeRangeMinimizer.minimizeZipCodeRanges(new String[]{
                "[61111,61111]", "[61112,61113]", "[61111,61111]", "[61117,61118]", "[61110,61119]", "[60000,70000]"
        });
        Assert.assertEquals("[60000,70000]", ZipCodeRangeUtil.join(newRanges, " "));
    }

    /**
     * Test case 5:
     *
     * Specify some ranges backwards
     *
     * Input: [21111,11111] [11111,21111] [11110,11111] [11118,10000] [11110,11119] [22110,23112]
     * Expected: [11111,21111] [22110,23112]
     */
    @Test
    public void overlapZipCodeRangeBackwards() {
        ZipCodeRange[] newRanges = ZipCodeRangeMinimizer.minimizeZipCodeRanges(new String[]{
                "[21111,11111]", "[11111,21111]", "[11110,11111]", "[11117,10000]", "[11110,11119]", "[22110,23112]"
        });
        Assert.assertEquals("[10000,21111] [22110,23112]", ZipCodeRangeUtil.join(newRanges, " "));
    }
}
