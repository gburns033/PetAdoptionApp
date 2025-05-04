package edu.gz.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.gz.model.*;

public class ShelterManager {
	private static ShelterManager instance;
	private Map<String, Shelter<? extends Pet>> shelters;
	private Set<Integer> usedIds = new HashSet<>();

	private ShelterManager() {
		shelters = new HashMap<>();
		shelters.put("Dogs", new Shelter<Dog>());
		shelters.put("Cats", new Shelter<Cat>());
		shelters.put("Rabbits", new Shelter<Rabbit>());
		shelters.put("Exotic", new Shelter<ExoticAnimalAdapter>());
	}

	public static synchronized ShelterManager getInstance() {
		if (instance == null) {
			instance = new ShelterManager();
		}

		return instance;
	}
	
	public boolean registerUsedId(int id) {
	    return usedIds.add(id);
	}
	
	public int generateUniqueId() {
	    int id = 1;
	    while (usedIds.contains(id)) {
	        id++;
	    }
	    
	    usedIds.add(id);
	    return id;
	}
	
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

	public boolean addDogToShelter(Dog dog) {
		return getDogShelter().addPet(dog);
	}

	public boolean addCatToShelter(Cat cat) {
		return getCatShelter().addPet(cat);
	}

	public boolean addRabbitToShelter(Rabbit rabbit) {
		return getRabbitShelter().addPet(rabbit);
	}

	public boolean addExoticToShelter(ExoticAnimalAdapter exotic) {
		return getExoticShelter().addPet(exotic);
	}

	public boolean adoptDog(int id) {
		return getDogShelter().adoptPet(id);
	}

	public boolean adoptCat(int id) {
		return getCatShelter().adoptPet(id);
	}

	public boolean adoptRabbit(int id) {
		return getRabbitShelter().adoptPet(id);
	}

	public boolean adoptExotic(int id) {
		return getExoticShelter().adoptPet(id);
	}
	
	public boolean removeDog(int id) {
		return getDogShelter().removePet(id);
	}
	
	public boolean removeCat(int id) {
	    return getCatShelter().removePet(id);
	}

	public boolean removeRabbit(int id) {
	    return getRabbitShelter().removePet(id);
	}

	public boolean removeExotic(int id) {
	    return getExoticShelter().removePet(id);
	}


	@SuppressWarnings("unchecked")
	public Shelter<Dog> getDogShelter() {
		return (Shelter<Dog>) shelters.get("Dogs");
	}

	@SuppressWarnings("unchecked")
	public Shelter<Cat> getCatShelter() {
		return (Shelter<Cat>) shelters.get("Cats");
	}

	@SuppressWarnings("unchecked")
	public Shelter<Rabbit> getRabbitShelter() {
		return (Shelter<Rabbit>) shelters.get("Rabbits");
	}

	@SuppressWarnings("unchecked")
	public Shelter<ExoticAnimalAdapter> getExoticShelter() {
		return (Shelter<ExoticAnimalAdapter>) shelters.get("Exotic");
	}

	public Shelter<? extends Pet> getShelter(String type) {
		return shelters.get(type);
	}

	public Map<String, Shelter<? extends Pet>> getAllShelters() {
		return shelters;
	}
	
	public List<Pet> getAllPets() {
		List<Pet> allPets = new ArrayList<>();

		for (Map.Entry<String, Shelter<? extends Pet>> entry : ShelterManager.getInstance().getAllShelters().entrySet()) {
			allPets.addAll(entry.getValue().getAllPets());
		}
		
		return allPets;
	}
	
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
