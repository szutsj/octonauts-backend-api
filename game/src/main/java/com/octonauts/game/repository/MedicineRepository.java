package com.octonauts.game.repository;

import com.octonauts.game.model.entity.Medicine;
import com.octonauts.game.model.entity.Octopod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends CrudRepository<Medicine, Long> {
    List<Medicine> findAllByOctopodAndUsedIsFalse(Octopod octopod);
}
