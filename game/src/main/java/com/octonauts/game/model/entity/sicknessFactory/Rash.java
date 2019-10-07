package com.octonauts.game.model.entity.sicknessFactory;

import com.octonauts.game.model.entity.Medicine;
import com.octonauts.game.model.enums.MedicineType;
import com.octonauts.game.model.enums.SicknessType;

import java.util.ArrayList;
import java.util.List;

public class Rash extends Sickness {

    public Rash() {
    }

    public Rash(int level) {
        super();
        this.setType(SicknessType.RASH);
        this.setLevel(level);
        this.setMedicineList(findMedicineForSicknessLevel());
    }

    public List<Medicine> findMedicineForSicknessLevel() {
        List<Medicine> medicines = new ArrayList<>();
        if (getLevel() > 0 && getLevel() < 4) {
            medicines.add(new Medicine(MedicineType.OINTMENT));
        }
        if (getLevel() == 2) {
            medicines.add(new Medicine(MedicineType.BANDAGE));
        }
        if (getLevel() == 3) {
            medicines.add(new Medicine(MedicineType.PILL));
        }
        return medicines;
    }

}
