package com.octonauts.game.repository;

import com.octonauts.game.model.entity.CrewMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends CrudRepository<CrewMember, Long> {
}
