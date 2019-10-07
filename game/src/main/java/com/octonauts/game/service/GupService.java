package com.octonauts.game.service;

import com.octonauts.game.model.entity.Gup;
import com.octonauts.game.model.entity.Octopod;
import com.octonauts.game.model.enums.GupType;
import com.octonauts.game.repository.GupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GupService {

    private GupRepository gupRepository;

    @Autowired
    public GupService(GupRepository gupRepository) {
        this.gupRepository = gupRepository;
    }

    public List<Gup> initGups(Octopod octopod){
        List<Gup> gups = new ArrayList<>();
        for (GupType gupType : GupType.values()) {
            Gup gup = new Gup(gupType, false, octopod);
            gupRepository.save(gup);
            gups.add(gup);
        }
        return gups;

    }

}
