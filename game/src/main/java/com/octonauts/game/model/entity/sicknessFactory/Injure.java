package com.octonauts.game.model.entity.sicknessFactory;

import com.octonauts.game.model.entity.cureFactory.Cure;
import com.octonauts.game.model.enums.MedicineType;
import com.octonauts.game.model.enums.SicknessType;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Injure extends Sickness {

    public Injure() {
    }

    public Injure(int level) {
        super(level);
        this.setType(SicknessType.INJURE);
    }

}