package edu.gz.model;

import java.util.Comparator;

/**
 * A comparator for comparing {@link Pet} objects by their species. It orders pets in alphabetical 
 * order of their species using {@code String.compareTo}.
 *
 * @param <T> the type of Pet to be compared
 */
public class SpeciesComparator<T extends Pet> implements Comparator<T> {

    /**
     * Compares two Pet objects by their species.
     *
     * @param a the first Pet to be compared
     * @param b the second Pet to be compared
     * @return a negative integer, zero, or a positive integer as
     *         the species of the first Pet is lexicographically less than, equal to,
     *         or greater than the species of the second
     */
    @Override
    public int compare(T a, T b) {
        return a.getSpecies().compareTo(b.getSpecies());
    }
}
