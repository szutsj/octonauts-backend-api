package com.octonauts.game.service;

import com.octonauts.game.model.entity.Medicine;
import com.octonauts.game.model.entity.Octopod;
import com.octonauts.game.model.enums.MedicineType;
import com.octonauts.game.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineService {

    private MedicineRepository medicineRepository;

    @Autowired
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> initMedicineStock(Octopod octopod) {
        List<Medicine> medicineStock = new ArrayList<>();
        for (MedicineType medicineType : MedicineType.values()) {
            Medicine medicine = new Medicine(medicineType, octopod);
            medicineRepository.save(medicine);
            medicineStock.add(medicine);
        }
        return medicineStock;
    }

}
