package edu.gz.model;

/**
 * An adapter class that allows an {@link ExoticAnimal} to be treated as a {@link Pet}.
 * This class extends {@link Pet} and uses an instance of {@link ExoticAnimal} to provide the necessary 
 * attributes for a pet, enabling exotic animals to be used in systems that expect {@code Pet} objects.
 */
public class ExoticAnimalAdapter extends Pet {
    private ExoticAnimal exoticAnimal;

    /**
     * Constructs an {@code ExoticAnimalAdapter} object using the provided {@link ExoticAnimal}.
     * The properties of the exotic animal are used to initialize the {@code Pet} attributes.
     * 
     * @param exoticAnimal the exotic animal to be adapted
     */
    public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {        
        super(exoticAnimal.getId(), exoticAnimal.getAnimalName(), exoticAnimal.getCategory(), exoticAnimal.getSubSpecies(), exoticAnimal.getYearsOld(), false);
        this.exoticAnimal = exoticAnimal;
    }

    /**
     * Constructs an {@code ExoticAnimalAdapter} object with the specified attributes.
     * This constructor allows setting the properties directly, bypassing the exotic animal object.
     * 
     * @param id the unique identifier for the pet
     * @param name the name of the pet
     * @param type the type of the pet (e.g., Mammal, Reptile)
     * @param species the species of the pet (e.g., Tiger, Iguana)
     * @param age the age of the pet
     * @param adopted the adoption status of the pet
     */
    public ExoticAnimalAdapter(int id, String name, String type, String species, int age, boolean adopted) {
        super(id, name, type, species, age, adopted);
        
        this.exoticAnimal = new ExoticAnimal(this);
    }
    
    /**
     * Returns the underlying {@link ExoticAnimal} instance associated with this adapter.
     *
     * @return the adapted exotic animal
     */
    public ExoticAnimal GetExoticAnimal() {
    	return exoticAnimal;
    }
}
