package edu.gz.model;

/**
 * Abstract class representing a Pet. This class serves as a blueprint for 
 * different types of pets, with variables such as {@code id}, {@code name}, 
 * {@code species}, {@code age}, and {@code adoption status}. It implements the 
 * {@link Comparable} interface, allowing pets to be compared by their {@code name}.
 */
public abstract class Pet implements Comparable<Pet> {
    
    protected int id;
    protected String name;
    protected String type;
    protected String species;
    protected int age;
    protected boolean adopted;

    /**
     * Constructs a new {@code Pet} object with the specified attributes.
     *
     * @param id the unique identifier for the pet
     * @param name the name of the pet
     * @param type the type of the pet (e.g., dog, cat)
     * @param species the species of the pet
     * @param age the age of the pet
     * @param adopted the adoption status of the pet
     */
    public Pet(int id, String name, String type, String species, int age, boolean adopted) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.species = species;
        this.age = age;
        this.adopted = adopted;
    }

    /**
     * Returns the ID of the pet.
     *
     * @return the ID of the pet
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the pet.
     *
     * @return the name of the pet
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of the pet (e.g., dog, cat).
     *
     * @return the type of the pet
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the species of the pet.
     *
     * @return the species of the pet
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Returns the age of the pet.
     *
     * @return the age of the pet
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns whether the pet is adopted.
     *
     * @return {@code true} if the pet is adopted, {@code false} otherwise
     */
    public boolean isAdopted() {
        return adopted;
    }

    /**
     * Sets the ID of the pet.
     *
     * @param id the new ID of the pet
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the name of the pet.
     *
     * @param name the new name of the pet
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the type of the pet.
     *
     * @param type the new type of the pet (e.g., dog, cat)
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the species of the pet.
     *
     * @param species the new species of the pet
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Sets the age of the pet.
     *
     * @param age the new age of the pet
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the adoption status of the pet.
     *
     * @param adopted the new adoption status of the pet
     */
    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    /**
     * Compares this {@code Pet} object to another {@code Pet} object by their name.
     * 
     * This method is used for natural ordering of pets based on their names.
     * 
     * @param other the {@code Pet} to be compared
     * @return a negative integer, zero, or a positive integer as this pet's name is
     *         lexicographically less than, equal to, or greater than the other pet's name
     */
    @Override
    public int compareTo(Pet other) {
        return this.name.compareTo(other.name);
    }
}
