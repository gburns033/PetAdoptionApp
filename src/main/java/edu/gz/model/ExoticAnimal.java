package edu.gz.model;

/**
 * Represents an ExoticAnimal with properties such as unique ID, name, category, sub-species, and age. 
 * This class provides getters and setters to access and modify these properties.
 */
public class ExoticAnimal {

    private int uniqueId;
    private String animalName;
    private String category;
    private String subSpecies;
    private int yearsOld;

    public ExoticAnimal() {
    	
    }
    
    public ExoticAnimal(ExoticAnimalAdapter adapter) {
    	this.uniqueId = adapter.getId();
    	this.animalName = adapter.getName();
    	this.category = adapter.getType();
    	this.subSpecies = adapter.getSpecies();
    	this.yearsOld = adapter.getAge();
    }
    
    /**
     * Returns the unique ID of the exotic animal.
     *
     * @return the unique ID of the animal
     */
    public int getUniqueId() {
        return uniqueId;
    }

    /**
     * Returns the name of the exotic animal.
     *
     * @return the name of the animal
     */
    public String getAnimalName() {
        return animalName;
    }

    /**
     * Returns the category of the exotic animal (e.g., Mammal, Reptile).
     *
     * @return the category of the animal
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the sub-species of the exotic animal.
     *
     * @return the sub-species of the animal
     */
    public String getSubSpecies() {
        return subSpecies;
    }

    /**
     * Returns the age of the exotic animal in years.
     *
     * @return the age of the animal
     */
    public int getYearsOld() {
        return yearsOld;
    }

    /**
     * Sets the unique ID of the exotic animal.
     *
     * @param uniqueId the new unique ID of the animal
     */
    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    /**
     * Sets the name of the exotic animal.
     *
     * @param animalName the new name of the animal
     */
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    /**
     * Sets the category of the exotic animal.
     *
     * @param category the new category of the animal
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Sets the sub-species of the exotic animal.
     *
     * @param subSpecies the new sub-species of the animal
     */
    public void setSubSpecies(String subSpecies) {
        this.subSpecies = subSpecies;
    }

    /**
     * Sets the age of the exotic animal in years.
     *
     * @param yearsOld the new age of the animal
     */
    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }
}
