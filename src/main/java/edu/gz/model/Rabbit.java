package edu.gz.model;

/**
 * Represents a Rabbit, which is a specific type of {@link Pet}. This class extends 
 * the {@link Pet} class and provides the specific type "Rabbit" as the type of the 
 * pet. It inherits all properties of a {@code Pet} and uses the constructor of the 
 * {@code Pet} class to initialize its attributes.
 */
public class Rabbit extends Pet {

    /**
     * Constructs a new {@code Rabbit} object with the specified attributes. The type of the pet is automatically set to "Rabbit".
     *
     * @param id the unique identifier for the rabbit
     * @param name the name of the rabbit
     * @param species the species of the rabbit (e.g., Dutch, Netherland Dwarf)
     * @param age the age of the rabbit
     * @param adopted the adoption status of the rabbit
     */
    public Rabbit(int id, String name, String species, int age, boolean adopted) {
        super(id, name, "Rabbit", species, age, adopted);
    }
}
