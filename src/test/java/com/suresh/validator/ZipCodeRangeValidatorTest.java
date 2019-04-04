package com.suresh.validator;

import com.suresh.codingchallenge.validator.ZipCodeRangeValidator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for ZipCodeRangeValidator class.
 *
 * @author Suresh Pasupuleti
 *
 */

public class ZipCodeRangeValidatorTest {
    /**
     * Test various valid zip code strings.
     */
    @Test
    public void validPatterns() {
        //valid
        Assert.assertEquals(true, ZipCodeRangeValidator.isZipCodeRangeValid("[12424,32424]"));

        //valid
        Assert.assertEquals(true, ZipCodeRangeValidator.isZipCodeRangeValid("[44444,55555]"));
    }

    /**
     * Test various invalid zip code strings.
     */
    @Test
    public void invalidPatterns() {
        //missing leading bracket
        Assert.assertEquals(false, ZipCodeRangeValidator.isZipCodeRangeValid("44444,55555]"));

        //missing trailing bracket
        Assert.assertEquals(false, ZipCodeRangeValidator.isZipCodeRangeValid("[44444,55555"));

        //no comma in between
        Assert.assertEquals(false, ZipCodeRangeValidator.isZipCodeRangeValid("[44444455555]"));

        //missing upper bound
        Assert.assertEquals(false, ZipCodeRangeValidator.isZipCodeRangeValid("[44444,]"));

        //missing lower bound
        Assert.assertEquals(false, ZipCodeRangeValidator.isZipCodeRangeValid("[,44444]"));

        //only brackets
        Assert.assertEquals(false, ZipCodeRangeValidator.isZipCodeRangeValid("[]"));

        //letters
        Assert.assertEquals(false, ZipCodeRangeValidator.isZipCodeRangeValid("[444a4,44444]"));

        //special characters
        Assert.assertEquals(false, ZipCodeRangeValidator.isZipCodeRangeValid("[$44a4,444#?]"));

        //null
        Assert.assertEquals(false, ZipCodeRangeValidator.isZipCodeRangeValid(null));
    }
}
