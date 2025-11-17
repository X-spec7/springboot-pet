package com.example.petservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.petservice.entity.Pet;
import com.example.petservice.repository.PetRepository;

@Service
public class PetService {
    
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPet(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet updatePet(Long id, Pet updatedPet) {
        return petRepository.findById(id)
                .map(pet -> {
                    pet.setName(updatedPet.getName());
                    pet.setType(updatedPet.getType());
                    pet.setAge(updatedPet.getAge());
                    return petRepository.save(pet);
                })
                .orElse(null);
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
