package edu.gz.model;

/**
 * Represents a Dog, which is a specific type of {@link Pet}. This class extends the 
 * {@link Pet} class and provides the specific type "Dog" as the type of the pet. It 
 * inherits all properties of a {@code Pet} and uses the constructor of the {@code Pet} 
 * class to initialize its attributes.
 */
public class Dog extends Pet {

    /**
     * Constructs a new {@code Dog} object with the specified attributes.
     * The type of the pet is automatically set to "Dog".
     *
     * @param id the unique identifier for the dog
     * @param name the name of the dog
     * @param species the species of the dog (e.g., Golden Retriever, German Shepherd)
     * @param age the age of the dog
     * @param adopted the adoption status of the dog
     */
    public Dog(int id, String name, String species, int age, boolean adopted) {
        super(id, name, "Dog", species, age, adopted);
    }
}
