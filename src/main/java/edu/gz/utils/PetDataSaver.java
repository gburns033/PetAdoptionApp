package edu.gz.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.gz.model.ExoticAnimal;
import edu.gz.model.ExoticAnimalAdapter;
import edu.gz.model.Pet;

/**
 * Utility class for saving pet data to JSON files.
 * This class handles serialization of standard and exotic pets to separate timestamped files.
 */
public class PetDataSaver {

    /**
     * Saves all standard pets (dogs, cats, rabbits) currently in the {@link ShelterManager}
     * to a JSON file. The filename is timestamped to ensure uniqueness.
     */
    public void savePets() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = timestamp + "_pets.json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Pet> allPets = new ArrayList<>();

        allPets.addAll(ShelterManager.getInstance().getDogShelter().getAllPets());
        allPets.addAll(ShelterManager.getInstance().getCatShelter().getAllPets());
        allPets.addAll(ShelterManager.getInstance().getRabbitShelter().getAllPets());

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(allPets, writer);
            System.out.println("Pet data has been saved successfully to: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the pet data: " + e.getMessage());
        }
    }

    /**
     * Saves all exotic pets from the given {@link ShelterManager} to a JSON file.
     * The data is extracted from {@link ExoticAnimalAdapter} and converted to raw {@link ExoticAnimal} objects.
     * The filename is timestamped to ensure uniqueness.
     *
     * @param manager the {@link ShelterManager} instance containing exotic pets
     */
    public void saveExoticAnimals(ShelterManager manager) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = timestamp + "_exotic_animals.json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<ExoticAnimal> exoticAnimals = new ArrayList<>();

        for (ExoticAnimalAdapter adapter : manager.getExoticShelter().getAllPets()) {
            exoticAnimals.add(adapter.GetExoticAnimal());
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(exoticAnimals, writer);
            System.out.println("Exotic pets data has been saved successfully to: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the exotic pet data: " + e.getMessage());
        }
    }
}
