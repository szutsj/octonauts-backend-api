package com.octonauts.game.repository;

import com.octonauts.game.model.entity.Gup;
import com.octonauts.game.model.entity.Octopod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GupRepository extends CrudRepository<Gup, Long> {
    List<Gup> findAllByOctopod(Octopod octopod);
}
