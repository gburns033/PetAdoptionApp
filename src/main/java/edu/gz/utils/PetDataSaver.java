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

public class PetDataSaver {

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
