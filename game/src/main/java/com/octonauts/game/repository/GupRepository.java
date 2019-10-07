package com.octonauts.game.repository;

import com.octonauts.game.model.entity.Gup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GupRepository extends CrudRepository<Gup, Long> {
}
