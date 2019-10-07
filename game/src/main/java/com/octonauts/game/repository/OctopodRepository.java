package com.octonauts.game.repository;

import com.octonauts.game.model.entity.Octopod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OctopodRepository extends CrudRepository<Octopod, Long> {
}
