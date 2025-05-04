package edu.gz.utils;

import edu.gz.model.*;

import com.google.gson.JsonObject;

/**
 * A utility class responsible for creating {@link Pet} instances from JSON data
 * or from explicitly provided parameters.
 */
public class PetFactory {

    /**
     * Creates a {@link Pet} instance from a {@link JsonObject}.
     * <p>
     * This method is typically used during JSON deserialization.
     * It extracts pet attributes from the JSON and returns the appropriate subclass instance.
     * </p>
     *
     * @param jsonObject the JSON object containing pet data
     * @return a {@link Pet} instance (Dog, Cat, Rabbit) based on the type field in the JSON
     * @throws IllegalArgumentException if the type field is not recognized
     */
    public static Pet createPet(JsonObject jsonObject) {
        int id = jsonObject.get("id").getAsInt();
        String name = jsonObject.get("name").getAsString();
        String type = jsonObject.get("type").getAsString();
        String species = jsonObject.get("species").getAsString();
        int age = jsonObject.get("age").getAsInt();
        boolean adopted = jsonObject.get("adopted").getAsBoolean();

        ShelterManager.getInstance().registerUsedId(id);

        switch (type) {
            case "Dog":
                return new Dog(id, name, species, age, adopted);
            case "Cat":
                return new Cat(id, name, species, age, adopted);
            case "Rabbit":
                return new Rabbit(id, name, species, age, adopted);
            default:
                throw new IllegalArgumentException("Unknown pet type: " + type);
        }
    }

    /**
     * Creates a {@link Pet} instance using explicitly provided parameters.
     * <p>
     * This method is useful for programmatically creating pets when JSON is not involved.
     * If the type is not Dog, Cat, or Rabbit, an {@link ExoticAnimalAdapter} is returned.
     * </p>
     *
     * @param type the type of the pet (e.g., Dog, Cat, Rabbit, or exotic type)
     * @param id the unique ID of the pet
     * @param name the pet's name
     * @param species the pet's species
     * @param age the pet's age
     * @return a {@link Pet} instance (including {@link ExoticAnimalAdapter} for unknown types)
     */
    public static Pet createPet(String type, int id, String name, String species, int age) {
        switch (type) {
            case "Dog":
                return new Dog(id, name, species, age, false);
            case "Cat":
                return new Cat(id, name, species, age, false);
            case "Rabbit":
                return new Rabbit(id, name, species, age, false);
            default:
                return new ExoticAnimalAdapter(id, name, type, species, age, false);
        }
    }
}
