package edu.gz.model;

import java.util.Comparator;

/**
 * A comparator for {@link Pet} objects that compares them based on their type.
 * This allows sorting pets alphabetically by their type (e.g., Mammal, Reptile).
 *
 * @param <T> the type of Pet to compare, must extend {@link Pet}
 */
public class TypeComparator<T extends Pet> implements Comparator<T> {

    /**
     * Compares two {@link Pet} objects by their type in lexicographical order.
     *
     * @param a the first pet to compare
     * @param b the second pet to compare
     * @return a negative integer, zero, or a positive integer if the type of {@code a}
     *         is less than, equal to, or greater than the type of {@code b}
     */
    @Override
    public int compare(T a, T b) {
        return a.getType().compareTo(b.getType());
    }
}
