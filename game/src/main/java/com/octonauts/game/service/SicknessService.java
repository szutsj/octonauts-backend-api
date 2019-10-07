package com.octonauts.game.service;

import com.octonauts.game.repository.SicknessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SicknessService {

    private SicknessRepository sicknessRepository;

    @Autowired
    public SicknessService(SicknessRepository sicknessRepository) {
        this.sicknessRepository = sicknessRepository;
    }
}
