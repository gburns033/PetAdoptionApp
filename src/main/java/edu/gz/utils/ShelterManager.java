package edu.gz.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.gz.model.*;

/**
 * The ShelterManager class is responsible for managing pet shelters. It provides functionality for adding, adopting, 
 * removing, and retrieving pets from various shelters. It also ensures unique IDs for pets.
 */
public class ShelterManager {
	private static ShelterManager instance;
	private Map<String, Shelter<? extends Pet>> shelters;
	private Set<Integer> usedIds = new HashSet<>();

	/**
	 * Private constructor to initialize the shelters for dogs, cats, rabbits, and exotic animals.
	 */
	private ShelterManager() {
		shelters = new HashMap<>();
		shelters.put("Dogs", new Shelter<Dog>());
		shelters.put("Cats", new Shelter<Cat>());
		shelters.put("Rabbits", new Shelter<Rabbit>());
		shelters.put("Exotic", new Shelter<ExoticAnimalAdapter>());
	}

	/**
	 * Returns the singleton instance of ShelterManager.
	 *
	 * @return The singleton instance of ShelterManager.
	 */
	public static synchronized ShelterManager getInstance() {
		if (instance == null) {
			instance = new ShelterManager();
		}

		return instance;
	}
	
	/**
	 * Registers a used pet ID to ensure uniqueness. 
	 *
	 * @param id The ID of the pet to register.
	 * @return true if the ID was successfully registered, false if the ID was already used.
	 */
	public boolean registerUsedId(int id) {
	    return usedIds.add(id);
	}
	
	/**
	 * Generates a unique ID by checking the used IDs and finding the first unused ID.
	 *
	 * @return A unique ID.
	 */
	public int generateUniqueId() {
	    int id = 1;
	    while (usedIds.contains(id)) {
	        id++;
	    }
	    
	    usedIds.add(id);
	    return id;
	}
	
	/**
	 * Adds a pet to the appropriate shelter based on its type.
	 *
	 * @param pet The pet to add.
	 * @return true if the pet was successfully added to the shelter, false otherwise.
	 */
	public boolean addPetToShelter(Pet pet) {
		if (pet instanceof Dog) {
			return ShelterManager.getInstance().addDogToShelter((Dog) pet);
		} else if (pet instanceof Cat) {
			return ShelterManager.getInstance().addCatToShelter((Cat) pet);
		} else if (pet instanceof Rabbit) {
			return ShelterManager.getInstance().addRabbitToShelter((Rabbit) pet);
		} else if (pet instanceof ExoticAnimalAdapter) {
			return ShelterManager.getInstance().addExoticToShelter((ExoticAnimalAdapter) pet);
		}
		return false;
	}

	/**
	 * Adds a dog to the dog shelter.
	 *
	 * @param dog The dog to add.
	 * @return true if the dog was successfully added, false otherwise.
	 */
	public boolean addDogToShelter(Dog dog) {
		return getDogShelter().addPet(dog);
	}

	/**
	 * Adds a cat to the cat shelter.
	 *
	 * @param cat The cat to add.
	 * @return true if the cat was successfully added, false otherwise.
	 */
	public boolean addCatToShelter(Cat cat) {
		return getCatShelter().addPet(cat);
	}

	/**
	 * Adds a rabbit to the rabbit shelter.
	 *
	 * @param rabbit The rabbit to add.
	 * @return true if the rabbit was successfully added, false otherwise.
	 */
	public boolean addRabbitToShelter(Rabbit rabbit) {
		return getRabbitShelter().addPet(rabbit);
	}

	/**
	 * Adds an exotic animal to the exotic animal shelter.
	 *
	 * @param exotic The exotic animal to add.
	 * @return true if the exotic animal was successfully added, false otherwise.
	 */
	public boolean addExoticToShelter(ExoticAnimalAdapter exotic) {
		return getExoticShelter().addPet(exotic);
	}

	/**
	 * Adopts a dog from the dog shelter by its ID.
	 *
	 * @param id The ID of the dog to adopt.
	 * @return true if the dog was successfully adopted, false otherwise.
	 */
	public boolean adoptDog(int id) {
		return getDogShelter().adoptPet(id);
	}

	/**
	 * Adopts a cat from the cat shelter by its ID.
	 *
	 * @param id The ID of the cat to adopt.
	 * @return true if the cat was successfully adopted, false otherwise.
	 */
	public boolean adoptCat(int id) {
		return getCatShelter().adoptPet(id);
	}

	/**
	 * Adopts a rabbit from the rabbit shelter by its ID.
	 *
	 * @param id The ID of the rabbit to adopt.
	 * @return true if the rabbit was successfully adopted, false otherwise.
	 */
	public boolean adoptRabbit(int id) {
		return getRabbitShelter().adoptPet(id);
	}

	/**
	 * Adopts an exotic animal from the exotic animal shelter by its ID.
	 *
	 * @param id The ID of the exotic animal to adopt.
	 * @return true if the exotic animal was successfully adopted, false otherwise.
	 */
	public boolean adoptExotic(int id) {
		return getExoticShelter().adoptPet(id);
	}
	
	/**
	 * Removes a dog from the dog shelter by its ID.
	 *
	 * @param id The ID of the dog to remove.
	 * @return true if the dog was successfully removed, false otherwise.
	 */
	public boolean removeDog(int id) {
		return getDogShelter().removePet(id);
	}
	
	/**
	 * Removes a cat from the cat shelter by its ID.
	 *
	 * @param id The ID of the cat to remove.
	 * @return true if the cat was successfully removed, false otherwise.
	 */
	public boolean removeCat(int id) {
	    return getCatShelter().removePet(id);
	}

	/**
	 * Removes a rabbit from the rabbit shelter by its ID.
	 *
	 * @param id The ID of the rabbit to remove.
	 * @return true if the rabbit was successfully removed, false otherwise.
	 */
	public boolean removeRabbit(int id) {
	    return getRabbitShelter().removePet(id);
	}

	/**
	 * Removes an exotic animal from the exotic animal shelter by its ID.
	 *
	 * @param id The ID of the exotic animal to remove.
	 * @return true if the exotic animal was successfully removed, false otherwise.
	 */
	public boolean removeExotic(int id) {
	    return getExoticShelter().removePet(id);
	}

	/**
	 * Retrieves the dog shelter.
	 *
	 * @return The dog shelter.
	 */
	@SuppressWarnings("unchecked")
	public Shelter<Dog> getDogShelter() {
		return (Shelter<Dog>) shelters.get("Dogs");
	}

	/**
	 * Retrieves the cat shelter.
	 *
	 * @return The cat shelter.
	 */
	@SuppressWarnings("unchecked")
	public Shelter<Cat> getCatShelter() {
		return (Shelter<Cat>) shelters.get("Cats");
	}

	/**
	 * Retrieves the rabbit shelter.
	 *
	 * @return The rabbit shelter.
	 */
	@SuppressWarnings("unchecked")
	public Shelter<Rabbit> getRabbitShelter() {
		return (Shelter<Rabbit>) shelters.get("Rabbits");
	}

	/**
	 * Retrieves the exotic animal shelter.
	 *
	 * @return The exotic animal shelter.
	 */
	@SuppressWarnings("unchecked")
	public Shelter<ExoticAnimalAdapter> getExoticShelter() {
		return (Shelter<ExoticAnimalAdapter>) shelters.get("Exotic");
	}

	/**
	 * Retrieves the shelter based on the type.
	 *
	 * @param type The type of shelter (e.g., "Dogs", "Cats", "Rabbits", "Exotic").
	 * @return The appropriate shelter or null if not found.
	 */
	public Shelter<? extends Pet> getShelter(String type) {
		return shelters.get(type);
	}

	/**
	 * Retrieves all shelters in the ShelterManager.
	 *
	 * @return A map of shelter names to their respective shelters.
	 */
	public Map<String, Shelter<? extends Pet>> getAllShelters() {
		return shelters;
	}
	
	/**
	 * Retrieves all pets from all shelters in the ShelterManager.
	 *
	 * @return A list of all pets.
	 */
	public List<Pet> getAllPets() {
		List<Pet> allPets = new ArrayList<>();

		for (Map.Entry<String, Shelter<? extends Pet>> entry : ShelterManager.getInstance().getAllShelters().entrySet()) {
			allPets.addAll(entry.getValue().getAllPets());
		}
		
		return allPets;
	}
	
	/**
	 * Retrieves a pet by its ID from all shelters.
	 *
	 * @param id The ID of the pet to retrieve.
	 * @return The pet with the given ID, or null if no pet with the ID exists.
	 */
	public Pet getPetById(int id) {
		List<Pet> pets = getAllPets();
		
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).getId() == id) {
				return pets.get(i);
			}
		}
		
		return null;
	}
}
