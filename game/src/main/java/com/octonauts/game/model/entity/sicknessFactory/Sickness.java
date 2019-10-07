package com.octonauts.game.model.entity.sicknessFactory;

import com.octonauts.game.model.entity.Animal;
import com.octonauts.game.model.entity.Medicine;
import com.octonauts.game.model.enums.SicknessType;

import javax.persistence.*;
import java.util.List;

@Table(name ="sicknesses")
@Entity
public abstract class Sickness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private SicknessType type;
    private int level;
    private int pointsGivenForCure;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sickness")
    private List<Medicine> medicineList;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "animals_id")
    private Animal animal;

    public Sickness() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SicknessType getType() {
        return type;
    }

    public void setType(SicknessType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPointsGivenForCure() {
        return pointsGivenForCure;
    }

    public void setPointsGivenForCure(int pointsGivenForCure) {
        this.pointsGivenForCure = pointsGivenForCure;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public abstract List<Medicine> findMedicineForSicknessLevel();
}
