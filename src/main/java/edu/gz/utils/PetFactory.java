package edu.gz.utils;

import edu.gz.model.*;

import com.google.gson.JsonObject;

public class PetFactory {

    public static Pet createPet(JsonObject jsonObject) {
        int id = jsonObject.get("id").getAsInt();
        String name = jsonObject.get("name").getAsString();
        String type = jsonObject.get("type").getAsString();
        String species = jsonObject.get("species").getAsString();
        int age = jsonObject.get("age").getAsInt();
        boolean adopted = jsonObject.get("adopted").getAsBoolean();

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
}
