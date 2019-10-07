package com.octonauts.game.model.entity;

import com.octonauts.game.model.entity.sicknessFactory.Sickness;
import com.octonauts.game.model.enums.MedicineType;

import javax.persistence.*;

@Table(name = "Medicines")
@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private MedicineType type;
    private int price;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "octopods_id")
    private Octopod octopod;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "sicknesses_id")
    private Sickness sickness;


    public Medicine(MedicineType type) {
        this.type = type;
    }

    public Medicine() {
    }

    public Medicine(MedicineType type, Octopod octopod) {
        this.type = type;
        this.octopod = octopod;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MedicineType getType() {
        return type;
    }

    public void setType(MedicineType type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Octopod getOctopod() {
        return octopod;
    }

    public void setOctopod(Octopod octopod) {
        this.octopod = octopod;
    }

    public Sickness getSickness() {
        return sickness;
    }

    public void setSickness(Sickness sickness) {
        this.sickness = sickness;
    }
}
