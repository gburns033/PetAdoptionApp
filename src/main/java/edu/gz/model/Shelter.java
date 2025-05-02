package edu.gz.model;

import java.util.*;

public class Shelter<T extends Pet> {
    private Map<Integer, T> pets;

    public Shelter() {
        pets = new HashMap<Integer, T>();
    }

    public boolean addPet(T pet) {
        if (pets.containsKey(pet.getId())) {
        	return false;
        }
        
        pets.put(pet.getId(), pet);
        return true;
    }

    public boolean removePet(int id) {
        return pets.remove(id) != null;
    }

    public boolean adoptPet(int id) {
        T pet = pets.get(id);
        if (pet == null || pet.isAdopted()) {
        	return false;
        }
        
        pet.setAdopted(true);
        return true;
    }

    public Pet getPetById(int id) {
        return pets.get(id);
    }

    public List<T> getAllPets() {
        return new ArrayList<T>(pets.values());
    }

    public void clear() {
        pets.clear();
    }

    public List<T> getSortedPets(Comparator<T> comparator) {
        List<T> sorted = getAllPets();
        sorted.sort(comparator);
        return sorted;
    }
}
