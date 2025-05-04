package edu.gz.utils;

import com.google.gson.*;
import edu.gz.model.*;

import java.lang.reflect.Type;

/**
 * Custom deserializer for {@link Pet} objects using Gson.
 * <p>
 * This class delegates the deserialization process to {@link PetFactory},
 * which decides the appropriate subtype (e.g., Dog, Cat, Rabbit, ExoticAnimalAdapter)
 * based on the JSON structure.
 * </p>
 */
public class PetDeserializer implements JsonDeserializer<Pet> {

    /**
     * Deserializes a JSON element into a {@link Pet} object.
     *
     * @param json the JSON data being deserialized
     * @param typeOfT the type of the object to deserialize to
     * @param context the context of the deserialization process
     * @return a {@link Pet} instance corresponding to the JSON input
     * @throws JsonParseException if the JSON is invalid or cannot be parsed properly
     */
    @Override
    public Pet deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        return PetFactory.createPet(jsonObject);
    }
}
