package com.suresh.codingchallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents a zip code range with an upper and lower bound.
 *
 * @author Suresh Pasupuleti
 *
 */

@Data
@AllArgsConstructor
public class ZipCodeRange {

    private int lowerBound;
    private int upperBound;

    /**
     * Compares equality of two zip code ranges by checking the equality of both lower and upper bounds.
     *
     * @param obj The other zip code range to compare equality with
     */
    @Override
    public boolean equals(Object obj) {
        ZipCodeRange range = (ZipCodeRange) obj;
        return this.lowerBound == range.lowerBound && this.upperBound == range.upperBound;
    }

    /**
     * @return A zip code range with the following format [#####,#####]
     */
    @Override
    public String toString() {
        return "[" + lowerBound + "," + upperBound + "]";
    }

}
