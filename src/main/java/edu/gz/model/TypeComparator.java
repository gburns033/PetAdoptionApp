package edu.gz.model;

import java.util.Comparator;


public class TypeComparator<T extends Pet> implements Comparator<T> {

    @Override
    public int compare(T a, T b) {
        return a.getType().compareTo(b.getType());
    }
}
