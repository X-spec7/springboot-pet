package com.example.petservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.petservice.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
    
}
