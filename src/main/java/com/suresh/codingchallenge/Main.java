package com.suresh.codingchallenge;

import com.suresh.codingchallenge.model.ZipCodeRange;
import com.suresh.codingchallenge.service.ZipCodeRangeMinimizer;
import com.suresh.codingchallenge.util.ZipCodeRangeUtil;

/**
 * Main class that accepts an array of 5-digit zip codes from the command line and reduces the number of ranges by merging together ones that overlap.
 *
 * @author Suresh Pasupuleti
 *
 */

public class Main {

    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("No input provided, input must be provided as 5-digit zip code ranges separated by spaces: [#####,#####] [#####,#####] [#####,#####]");
            System.exit(1);
        }

        //format output to flatten it as a string
        System.out.println("Input: " + ZipCodeRangeUtil.join(args, " "));

        //run reducer which validates data and reduces the zip code array
        ZipCodeRange[] ranges = ZipCodeRangeMinimizer.minimizeZipCodeRanges(args);

        //display output as a flattened string
        System.out.println("Output: " + ZipCodeRangeUtil.join(ranges, " "));
    }
}
