package edu.gz.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.gz.model.Pet;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class JsonLoader {

    public static List<Pet> loadPets(String resourcePath) {
        try {
            InputStream is = JsonLoader.class.getResourceAsStream(resourcePath);
            if (is == null) {
                throw new RuntimeException("File not found: " + resourcePath);
            }

            InputStreamReader reader = new InputStreamReader(is);
            Type petListType = new TypeToken<List<Pet>>(){}.getType();
            return new Gson().fromJson(reader, petListType);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load pets: " + e.getMessage(), e);
        }
    }
}
