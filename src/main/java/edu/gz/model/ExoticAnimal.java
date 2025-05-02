package edu.gz.model;

public class ExoticAnimal {
	private int uniqueId;
	private String animalName;
	private String category;
	private String subSpecies;
	private int yearsOld;

	public int getUniqueId() {
		return uniqueId;
	}

	public String getAnimalName() {
		return animalName;
	}

	public String getCategory() {
		return category;
	}

	public String getSubSpecies() {
		return subSpecies;
	}

	public int getYearsOld() {
		return yearsOld;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}

	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}
}
