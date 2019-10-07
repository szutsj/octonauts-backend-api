package com.octonauts.game.service;

import com.octonauts.game.model.entity.Octopod;
import com.octonauts.game.model.entity.User;
import com.octonauts.game.repository.OctopodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OctopodService {

    private OctopodRepository octopodRepository;
    private CrewService crewService;
    private MedicineService medicineService;
    private GupService gupService;
    private SicknessService sicknessService;
    private AnimalService animalService;

    @Autowired
    public OctopodService(OctopodRepository octopodRepository, CrewService crewService,
                          MedicineService medicineService, GupService gupService,
                          SicknessService sicknessService, AnimalService animalService) {
        this.octopodRepository = octopodRepository;
        this.crewService = crewService;
        this.medicineService = medicineService;
        this.gupService = gupService;
        this.sicknessService = sicknessService;
        this.animalService = animalService;
    }

    public Octopod initOctopod(User user){
        Octopod octopod = new Octopod();
        octopodRepository.save(octopod);
        octopod.setGupList(gupService.initGups(octopod));
        octopod.setMedicineList(medicineService.initMedicineStock(octopod));
        octopod.setCrewMemberList(crewService.initCrew(octopod));
        octopodRepository.save(octopod);
        return octopod;
    }

    public Octopod save(Octopod octopod){
        return octopodRepository.save(octopod);
    }

}
