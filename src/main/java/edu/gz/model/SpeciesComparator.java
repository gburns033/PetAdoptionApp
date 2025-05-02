package edu.gz.model;

import java.util.Comparator;

public class SpeciesComparator<T extends Pet> implements Comparator<T> {
	@Override
	public int compare(T a, T b) {
		return a.getSpecies().compareTo(b.getSpecies());
	}
}
