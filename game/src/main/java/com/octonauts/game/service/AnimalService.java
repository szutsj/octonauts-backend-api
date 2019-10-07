package com.octonauts.game.service;

import com.octonauts.game.model.entity.Animal;
import com.octonauts.game.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Optional<Animal> findById(Long id){
        return animalRepository.findById(id);
    }

}
