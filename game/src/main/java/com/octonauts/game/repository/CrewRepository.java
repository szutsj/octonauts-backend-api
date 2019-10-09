package com.octonauts.game.repository;

import com.octonauts.game.model.entity.CrewMember;
import com.octonauts.game.model.entity.Octopod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrewRepository extends CrudRepository<CrewMember, Long> {
    List<CrewMember> findAllByOctopod(Octopod octopod);
}
