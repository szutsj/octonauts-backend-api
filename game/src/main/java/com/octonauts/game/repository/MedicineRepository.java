package com.octonauts.game.repository;

import com.octonauts.game.model.entity.Medicine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends CrudRepository<Medicine, Long> {
}
