package edu.gz.model;

/**
 * Represents a Cat, which is a specific type of {@link Pet}. This class extends the 
 * {@link Pet} class and provides the specific type "Cat" as the type of the pet. It 
 * inherits all properties of a {@code Pet} and uses the constructor of the {@code Pet} 
 * class to initialize its attributes.
 */
public class Cat extends Pet {

    /**
     * Constructs a new {@code Cat} object with the specified attributes. The type of the pet is automatically set to "Cat".
     *
     * @param id the unique identifier for the cat
     * @param name the name of the cat
     * @param species the species of the cat (e.g., Persian, Siamese)
     * @param age the age of the cat
     * @param adopted the adoption status of the cat
     */
    public Cat(int id, String name, String species, int age, boolean adopted) {
        super(id, name, "Cat", species, age, adopted);
    }
}
