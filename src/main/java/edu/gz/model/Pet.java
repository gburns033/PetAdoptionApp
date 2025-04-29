package edu.gz.model;

public abstract class Pet {
	protected int id;
	protected String name;
	protected String type;
	protected String species;
	protected int age;
	protected boolean adopted;
	
	public Pet(int id, String name, String type, String species, int age, boolean adopted) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.adopted = adopted;
	}
}