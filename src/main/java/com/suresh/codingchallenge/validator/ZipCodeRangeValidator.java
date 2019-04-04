package com.suresh.codingchallenge.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipCodeRangeValidator {
    //test for valid zip code pattern using regex
    private static final Pattern zipCodePattern = Pattern.compile("\\[\\d{5},\\d{5}\\]");

    /**
     * Validates a zip code range string of the format [#####,#####].
     *
     * @param String
     * @return true of valid, false if not
     */

    public static boolean isZipCodeRangeValid(String zipCodeRange) {

        boolean valid;

        if(zipCodeRange == null) {
            valid = false;
        } else {
            //check if regex matches, set valid to true if matches found
            Matcher matcher = zipCodePattern.matcher(zipCodeRange);
            valid = matcher.matches();
        }

        return valid;
    }
}
