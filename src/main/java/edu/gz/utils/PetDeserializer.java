package edu.gz.utils;

import com.google.gson.*;
import edu.gz.model.*;

import java.lang.reflect.Type;

public class PetDeserializer implements JsonDeserializer<Pet> {
    @Override
    public Pet deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        return PetFactory.createPet(jsonObject);
    }
}
