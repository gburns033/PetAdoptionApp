package edu.gz.model;

import java.util.Comparator;

/**
 * A comparator for comparing {@link Pet} objects by their age. It orders pets in ascending 
 * order of their age using {@code Integer.compare}.
 *
 * @param <T> the type of Pet to be compared
 */
public class AgeComparator<T extends Pet> implements Comparator<T> {

    /**
     * Compares two Pet objects by their age.
     *
     * @param a the first Pet to be compared
     * @param b the second Pet to be compared
     * @return a negative integer, zero, or a positive integer as
     *         the age of the first Pet is less than, equal to, or greater than the second
     */
    @Override
    public int compare(T a, T b) {
        return Integer.compare(a.getAge(), b.getAge());
    }
}
