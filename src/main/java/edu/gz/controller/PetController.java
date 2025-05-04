package edu.gz.controller;

import edu.gz.model.*;
import java.io.*;
import java.util.*;

/**
 * Controller class that provides an interface to interact with a {@link Shelter} of {@link Pet} objects.
 * It handles operations such as adding, adopting, removing, and retrieving pets.
 */
public class PetController {
    private Shelter<Pet> shelter;

    /**
     * Constructs a PetController with the specified shelter.
     *
     * @param shelter the shelter that this controller will manage
     */
    public PetController(Shelter<Pet> shelter) {
        this.shelter = shelter;
    }

    /**
     * Adds a pet to the shelter.
     *
     * @param pet the pet to add
     * @return true if the pet was successfully added; false otherwise
     */
    public boolean addPet(Pet pet) {
        return shelter.addPet(pet);
    }

    /**
     * Marks a pet as adopted in the shelter using its ID.
     *
     * @param id the ID of the pet to adopt
     * @return true if the pet was successfully adopted; false otherwise
     */
    public boolean adoptPet(int id) {
        return shelter.adoptPet(id);
    }

    /**
     * Removes a pet from the shelter by its ID.
     *
     * @param id the ID of the pet to remove
     * @return true if the pet was successfully removed; false otherwise
     */
    public boolean removePet(int id) {
        return shelter.removePet(id);
    }

    /**
     * Retrieves a list of pets sorted using the specified comparator.
     *
     * @param comparator the comparator to determine the order of the pets
     * @return a sorted list of pets
     */
    public List<Pet> getSortedPets(Comparator<Pet> comparator) {
        return shelter.getSortedPets(comparator);
    }

    /**
     * Retrieves a pet by its ID.
     *
     * @param id the ID of the pet to retrieve
     * @return the pet with the specified ID, or null if not found
     */
    public Pet getPetById(int id) {
        return shelter.getPetById(id);
    }

    /**
     * Retrieves a list of all pets in the shelter.
     *
     * @return a list of all pets
     */
    public List<Pet> getAllPets() {
        return shelter.getAllPets();
    }
}
