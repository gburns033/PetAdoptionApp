package edu.gz.controller;

import edu.gz.model.*;
import java.io.*;
import java.util.*;

public class PetController {
    private Shelter<Pet> shelter;

    public PetController(Shelter<Pet> shelter) {
        this.shelter = shelter;
    }

    public boolean addPet(Pet pet) {
        return shelter.addPet(pet);
    }

    public boolean adoptPet(int id) {
        return shelter.adoptPet(id);
    }

    public boolean removePet(int id) {
        return shelter.removePet(id);
    }

    public List<Pet> getSortedPets(Comparator<Pet> comparator) {
        return shelter.getSortedPets(comparator);
    }

    public Pet getPetById(int id) {
        return shelter.getPetById(id);
    }

    public List<Pet> getAllPets() {
        return shelter.getAllPets();
    }
}
