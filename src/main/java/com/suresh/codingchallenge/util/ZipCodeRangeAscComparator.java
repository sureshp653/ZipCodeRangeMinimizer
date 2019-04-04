package com.suresh.codingchallenge.util;

import com.suresh.codingchallenge.model.ZipCodeRange;

import java.util.Comparator;



public class ZipCodeRangeAscComparator implements Comparator<ZipCodeRange> {

    /**
     * Compares two ranges based on their lowerBound and upperBound values.
     *
     * @param firstRange The first zip code range to compare
     * @param secondRange The second zip code range to compare
     * @return An integer that indicates if range1 is greater, equal to, or less than range2 when sorted
     */

    public int compare(ZipCodeRange firstRange, ZipCodeRange secondRange) {

        //first compare lower bounds to get ascending order
        int comp = firstRange.getLowerBound() - secondRange.getLowerBound();

        //if there is a tie for the lower bound, we want the upper bound to be in ascending order
        if(comp == 0) {
            comp = firstRange.getUpperBound() - secondRange.getUpperBound();
        }
        return comp;
    }

}
