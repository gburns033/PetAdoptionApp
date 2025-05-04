package edu.gz.utils;

import com.google.gson.*;
import edu.gz.model.*;

import java.lang.reflect.Type;

/**
 * Custom deserializer for converting JSON objects into {@link ExoticAnimalAdapter} instances.
 * This class is used by Gson to deserialize JSON representations of exotic animals
 * into their corresponding adapter objects.
 */
public class ExoticAnimalDeserializer implements JsonDeserializer<ExoticAnimalAdapter> {

    /**
     * Deserializes the specified JSON element into an {@link ExoticAnimalAdapter}.
     *
     * @param json the JSON data being deserialized
     * @param typeOfT the type of the Object to deserialize to
     * @param context the deserialization context
     * @return an {@code ExoticAnimalAdapter} containing a deserialized {@code ExoticAnimal}
     * @throws JsonParseException if the JSON is not in the expected format
     */
    @Override
    public ExoticAnimalAdapter deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String uniqueId = jsonObject.get("uniqueId").getAsString();
        String animalName = jsonObject.get("animalName").getAsString();
        String category = jsonObject.get("category").getAsString();
        String subSpecies = jsonObject.get("subSpecies").getAsString();
        int yearsOld = jsonObject.get("yearsOld").getAsInt();

        ExoticAnimal exoticAnimal = new ExoticAnimal();
        exoticAnimal.setUniqueId(uniqueId);
        exoticAnimal.setAnimalName(animalName);
        exoticAnimal.setCategory(category);
        exoticAnimal.setSubSpecies(subSpecies);
        exoticAnimal.setYearsOld(yearsOld);

        return new ExoticAnimalAdapter(exoticAnimal);
    }
}
