package edu.gz.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.gz.model.*;

public class ShelterManager {
	private static ShelterManager instance;
	private Map<String, Shelter<? extends Pet>> shelters;

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
}
