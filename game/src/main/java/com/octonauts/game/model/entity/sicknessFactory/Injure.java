package com.octonauts.game.model.entity.sicknessFactory;

import com.octonauts.game.model.entity.Medicine;
import com.octonauts.game.model.enums.MedicineType;
import com.octonauts.game.model.enums.SicknessType;

import java.util.ArrayList;
import java.util.List;

public class Injure extends Sickness {

    public Injure() {
    }

    public Injure(int level) {
        super();
        this.setType(SicknessType.INJURE);
        this.setLevel(level);
        this.setMedicineList(findMedicineForSicknessLevel());
    }

    public List<Medicine> findMedicineForSicknessLevel() {
        List<Medicine> medicines = new ArrayList<>();
        if (getLevel() == 1) {
            medicines.add(new Medicine(MedicineType.OINTMENT));
        }
        if (getLevel() <= 2 && getLevel() < 4) {
            medicines.add(new Medicine(MedicineType.BANDAGE));
        }
        if (getLevel() == 3) {
            medicines.add(new Medicine(MedicineType.RTG));
        }
        return medicines;
    }

}