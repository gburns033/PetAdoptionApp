package edu.gz.model;

import java.util.Comparator;

public class AgeComparator<T extends Pet> implements Comparator<T> {
	@Override
	public int compare(T a, T b) {
		return Integer.compare(a.getAge(), b.getAge());
	}
}
