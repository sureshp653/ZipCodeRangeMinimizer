package com.suresh.codingchallenge.service;

import com.suresh.codingchallenge.model.ZipCodeRange;
import com.suresh.codingchallenge.util.ZipCodeRangeAscComparator;
import com.suresh.codingchallenge.validator.ZipCodeRangeValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class will take a collection of ranges and produce the minimum number of ranges that are equivalent to the input.
 *
 * For example: [90000,90004] [90003,90004] would return [90000,90004] due to the collection of ranges overlapping.
 *
 * @author Suresh Pasupuleti
 *
 */

public class ZipCodeRangeMinimizer {

    /**
     * Accepts an array of zip code ranges and produces a reduced array that represents the same ranges.
     *
     * @param ranges An array of zip code ranges
     * @return A reduced array that represents the same ranges
     */

    public static ZipCodeRange[] minimizeZipCodeRanges(String[] ranges) {

        List<String> invalidRanges = new ArrayList<>();
        List<ZipCodeRange> validRanges = new ArrayList<>();

        for(String range : ranges) {
            if(ZipCodeRangeValidator.isZipCodeRangeValid(range)) {
                String tokens[] = range.replace("[","").replace("]", "").split(",");

                int lowerBound = Integer.parseInt(tokens[0]);
                int upperBound = Integer.parseInt(tokens[1]);

                //switch upper bound and lower bound if upper bound is less,
                //we don't care about the direction of the ranges but for consolidation we need
                //the lowerBound to be on the left
                if(upperBound < lowerBound) {
                    int temp = lowerBound;
                    lowerBound = upperBound;
                    upperBound = temp;
                }
                validRanges.add(new ZipCodeRange(lowerBound, upperBound));
            } else {
                invalidRanges.add(range);
            }
        }

        if(invalidRanges.size() > 0) {
            throw new IllegalArgumentException("Invalid ranges found: " + invalidRanges + ", input must be provided as 5-digit zip code ranges separated by spaces: [#####,#####] [#####,#####] [#####,#####]");
        } else {
            return minimizeZipCodeRanges(validRanges);
        }
    }

    /**
     * Internal method for reducing a list of overlapping zip code ranges.
     *
     * @param ranges List of valid zip code ranges
     * @return A reduced array that represents the same ranges
     */

    private static ZipCodeRange[] minimizeZipCodeRanges(List<ZipCodeRange> ranges) {

        //if ranges is null or empty return input
        if(ranges == null) {
            return null;
        }

        if(ranges.size() == 0) {
            return new ZipCodeRange[0];
        }

        //Sort ranges in ascending order by lowerBound and upperBound
        Collections.sort(ranges, new ZipCodeRangeAscComparator());

        List<ZipCodeRange> reducedRanges = new ArrayList<>();

        reducedRanges.add(ranges.get(0));

        //iterate through the remaining ranges to determine where we can reduce,
        //if (n).upperBound >= (n+1).lowerBound we can consolidate ranges,
        //if (n) == (n+1) we have a duplicate range that we can ignore
        //if range can't be consolidated with the current add it to the list and set as currentRange
        ZipCodeRange currentZipCodeRange = ranges.get(0);
        int currentIdx = 0;
        for(int i = 1; i < ranges.size(); i++) {
            ZipCodeRange nextZipCodeRange = ranges.get(i);

            if(!currentZipCodeRange.equals(nextZipCodeRange)) {

                //overlap between upper bound of current and lower bound of next, consolidate range
                if(currentZipCodeRange.getUpperBound() >= nextZipCodeRange.getLowerBound()) {

                    //whichever of the two upper bounds is the largest use that as the new upper bound of the consolidated range
                    int upperBound;
                    if(currentZipCodeRange.getUpperBound() > nextZipCodeRange.getUpperBound()) {
                        upperBound = currentZipCodeRange.getUpperBound();
                    } else {
                        upperBound = nextZipCodeRange.getUpperBound();
                    }

                    ZipCodeRange newZipCodeRange = new ZipCodeRange(currentZipCodeRange.getLowerBound(), upperBound);
                    currentZipCodeRange = newZipCodeRange;
                    reducedRanges.set(currentIdx, newZipCodeRange);
                } else {
                    //no overlap, set nextZipCodeRange as currentZipCodeRange and add to list
                    currentZipCodeRange = nextZipCodeRange;
                    reducedRanges.add(nextZipCodeRange);
                    currentIdx = i;
                }
            }
        }

        //convert zip code range list to array
        ZipCodeRange[] arr = new ZipCodeRange[reducedRanges.size()];
        arr = reducedRanges.toArray(arr);

        return arr;
    }

}
