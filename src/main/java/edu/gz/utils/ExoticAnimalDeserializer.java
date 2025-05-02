package edu.gz.utils;

import com.google.gson.*;
import edu.gz.model.*;

import java.lang.reflect.Type;

public class ExoticAnimalDeserializer implements JsonDeserializer<ExoticAnimalAdapter> {
    @Override
    public ExoticAnimalAdapter deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String uniqueId = jsonObject.get("uniqueId").getAsString();
        String animalName = jsonObject.get("animalName").getAsString();
        String category = jsonObject.get("category").getAsString();
        String subSpecies = jsonObject.get("subSpecies").getAsString();
        int yearsOld = jsonObject.get("yearsOld").getAsInt();

        ExoticAnimal exoticAnimal = new ExoticAnimal();
        exoticAnimal.setUniqueId(Integer.parseInt(uniqueId.substring(3)));
        exoticAnimal.setAnimalName(animalName);
        exoticAnimal.setCategory(category);
        exoticAnimal.setSubSpecies(subSpecies);
        exoticAnimal.setYearsOld(yearsOld);

        return new ExoticAnimalAdapter(exoticAnimal);
    }
}
