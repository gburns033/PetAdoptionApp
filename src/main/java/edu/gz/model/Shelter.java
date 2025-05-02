package edu.gz.model;

import java.util.*;

/**
 * A class representing a shelter for pets, where pets are stored in a {@link Map}.
 * It allows for adding, removing, adopting, and retrieving pets by their ID. 
 * Pets can also be sorted using a {@link Comparator}.
 * 
 * @param <T> the type of pet managed by the shelter
 */
public class Shelter<T extends Pet> {
    private Map<Integer, T> pets;

    /**
     * Constructs an empty shelter.
     */
    public Shelter() {
        pets = new HashMap<Integer, T>();
    }

    /**
     * Adds a pet to the shelter.
     * 
     * @param pet the pet to be added
     * @return {@code true} if the pet was added successfully, {@code false} if a pet with the same ID already exists
     */
    public boolean addPet(T pet) {
        if (pets.containsKey(pet.getId())) {
            return false;
        }
        
        pets.put(pet.getId(), pet);
        return true;
    }

    /**
     * Removes a pet from the shelter by its ID.
     * 
     * @param id the ID of the pet to be removed
     * @return {@code true} if the pet was removed successfully, {@code false} if no pet with the given ID was found
     */
    public boolean removePet(int id) {
        return pets.remove(id) != null;
    }

    /**
     * Adopts a pet by marking it as adopted.
     * 
     * @param id the ID of the pet to be adopted
     * @return {@code true} if the pet was adopted successfully, {@code false} if the pet is already adopted or doesn't exist
     */
    public boolean adoptPet(int id) {
        T pet = pets.get(id);
        if (pet == null || pet.isAdopted()) {
            return false;
        }
        
        pet.setAdopted(true);
        return true;
    }

    /**
     * Retrieves a pet from the shelter by its ID.
     * 
     * @param id the ID of the pet
     * @return the pet with the given ID, or {@code null} if no pet with that ID exists
     */
    public Pet getPetById(int id) {
        return pets.get(id);
    }

    /**
     * Returns a list of all pets in the shelter.
     * 
     * @return a list of all pets
     */
    public List<T> getAllPets() {
        return new ArrayList<T>(pets.values());
    }

    /**
     * Clears all pets from the shelter.
     */
    public void clear() {
        pets.clear();
    }

    /**
     * Returns a list of pets sorted by the given comparator.
     * 
     * @param comparator the comparator to use for sorting
     * @return a sorted list of pets
     */
    public List<T> getSortedPets(Comparator<T> comparator) {
        List<T> sorted = getAllPets();
        sorted.sort(comparator);
        return sorted;
    }
}
