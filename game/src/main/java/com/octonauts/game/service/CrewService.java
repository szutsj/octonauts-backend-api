package com.octonauts.game.service;

import com.octonauts.game.model.entity.CrewMember;
import com.octonauts.game.model.entity.Octopod;
import com.octonauts.game.model.enums.CrewMembers;
import com.octonauts.game.repository.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrewService {

    private CrewRepository crewRepository;

    @Autowired
    public CrewService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    public List<CrewMember> initCrew(Octopod octopod){
        List<CrewMember> crew = new ArrayList<>();
        for (CrewMembers crewMember : CrewMembers.values()) {
            CrewMember newCrewMember;
            if (crewMember.equals(CrewMembers.CAPTAIN) || crewMember.equals(CrewMembers.PESO)){
                newCrewMember = new CrewMember(crewMember, true, octopod);
            } else {
                newCrewMember = new CrewMember(crewMember, false, octopod);
            }
            crewRepository.save(newCrewMember);
            crew.add(newCrewMember);
        }
        return crew;

    }
}
