package edu.gz.model;

public class Dog extends Pet {
	public Dog(int id, String name, String species, int age, boolean adopted) {
		super(id, name, "Dog", species, age, adopted);
	}
}