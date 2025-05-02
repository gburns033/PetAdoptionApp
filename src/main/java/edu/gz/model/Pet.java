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

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getSpecies() {
		return species;
	}

	public int getAge() {
		return age;
	}

	public boolean isAdopted() {
		return adopted;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
}
