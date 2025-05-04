package edu.gz.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import edu.gz.model.*;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

/**
 * JsonLoader is responsible for loading pet data from JSON files and populating the shelters
 * within the ShelterManager.
 */
public class JsonLoader {
	
	/**
	 * Loads pets data from the specified JSON resource path, deserializes the data into Pet objects,
	 * and adds them to the appropriate shelters in the ShelterManager.
	 *
	 * @param resourcePath The path to the JSON file containing pet data.
	 * @return An instance of ShelterManager populated with pets.
	 * @throws RuntimeException If the file is not found or an error occurs during deserialization.
	 */
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

	/**
	 * Loads exotic pets data from the specified JSON resource path, deserializes the data into ExoticAnimalAdapter objects,
	 * and adds them to the exotic shelter in the ShelterManager.
	 *
	 * @param resourcePath The path to the JSON file containing exotic animal data.
	 * @return An instance of ShelterManager populated with exotic animals.
	 * @throws RuntimeException If the file is not found or an error occurs during deserialization.
	 */
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
				if (manager.registerUsedId(exoticPet.getId()) == false) {
					exoticPet.setId(manager.generateUniqueId());
				}
				
				manager.addExoticToShelter(exoticPet);
			}

			return manager;

		} catch (Exception e) {
			throw new RuntimeException("Failed to load exotic animals: " + e.getMessage(), e);
		}
	}
}