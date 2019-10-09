package com.octonauts.game.repository;

import com.octonauts.game.model.entity.Animal;
import com.octonauts.game.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
    Animal save(Animal animal);
    List<Animal> findAnimalsByTreatmentStartedAtIsNull();
    List<Animal> findAnimalsByUser(User user);
}
