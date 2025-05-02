package edu.gz.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import edu.gz.model.*;

import java.io.InputStreamReader;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class JsonLoader {
	public static ShelterManager loadPets(String resourcePath) {
		try {
			Gson gson = new GsonBuilder().registerTypeAdapter(Pet.class, new PetDeserializer()).create();

			InputStream is = JsonLoader.class.getResourceAsStream(resourcePath);
			if (is == null) {
				throw new RuntimeException("File not found: " + resourcePath);
			}

			InputStreamReader reader = new InputStreamReader(is);

			Type petListType = new TypeToken<List<Pet>>() {
			}.getType();
			List<Pet> pets = gson.fromJson(reader, petListType);

			ShelterManager manager = ShelterManager.getInstance();

			for (Pet pet : pets) {
				if (pet instanceof Dog) {
					manager.addDogToShelter((Dog) pet);
				} else if (pet instanceof Cat) {
					manager.addCatToShelter((Cat) pet);
				} else if (pet instanceof Rabbit) {
					manager.addRabbitToShelter((Rabbit) pet);
				} else if (pet instanceof ExoticAnimalAdapter) {
					manager.addExoticToShelter((ExoticAnimalAdapter) pet);
				}
			}

			return manager;

		} catch (Exception e) {
			throw new RuntimeException("Failed to load pets: " + e.getMessage(), e);
		}
	}

	public static ShelterManager loadExoticPets(String resourcePath) {
		try {
			Gson gson = new GsonBuilder().registerTypeAdapter(ExoticAnimalAdapter.class, new ExoticAnimalDeserializer())
					.registerTypeAdapter(Pet.class, new PetDeserializer()).create();

			InputStream is = JsonLoader.class.getResourceAsStream(resourcePath);
			if (is == null) {
				throw new RuntimeException("File not found: " + resourcePath);
			}

			InputStreamReader reader = new InputStreamReader(is);

			Type exoticPetListType = new TypeToken<List<ExoticAnimalAdapter>>() {
			}.getType();
			List<ExoticAnimalAdapter> exoticPets = gson.fromJson(reader, exoticPetListType);

			ShelterManager manager = ShelterManager.getInstance();

			for (ExoticAnimalAdapter exoticPet : exoticPets) {
				manager.addExoticToShelter(exoticPet);
			}

			return manager;

		} catch (Exception e) {
			throw new RuntimeException("Failed to load exotic animals: " + e.getMessage(), e);
		}
	}
}
