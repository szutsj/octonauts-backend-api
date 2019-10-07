package com.octonauts.game.model.entity.sicknessFactory;

import com.octonauts.game.model.entity.Medicine;
import com.octonauts.game.model.enums.MedicineType;
import com.octonauts.game.model.enums.SicknessType;

import java.util.ArrayList;
import java.util.List;

public class Indigestion extends Sickness {

    public Indigestion() {
    }

    public Indigestion(int level){
        super();
        this.setType(SicknessType.INDIGESTION);
        setLevel(level);
        setMedicineList(findMedicineForSicknessLevel());
    }

    public List<Medicine> findMedicineForSicknessLevel(){
        List<Medicine> medicines = new ArrayList<>();
        if (getLevel() > 0 && getLevel() < 4){
            medicines.add(new Medicine(MedicineType.TEA));
            medicines.add(new Medicine(MedicineType.DIET));
        }
        if (getLevel() == 2){
            medicines.add(new Medicine(MedicineType.PILL));
        }
        if (getLevel() == 3){
            medicines.add(new Medicine(MedicineType.INJECTION));
        }
        return medicines;
    }
}
