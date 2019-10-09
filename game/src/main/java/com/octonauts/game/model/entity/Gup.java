package com.octonauts.game.model.entity;

import com.octonauts.game.model.enums.GupType;

import javax.persistence.*;

@Table(name = "gups")
@Entity
public class Gup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private GupType type;
    private boolean active;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "octopods_id")
    private Octopod octopod;

    public Gup() {
    }

    public Gup(GupType type, boolean active, Octopod octopod) {
        this.type = type;
        this.active = active;
        this.octopod = octopod;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GupType getType() {
        return type;
    }

    public void setType(GupType type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Octopod getOctopod() {
        return octopod;
    }

    public void setOctopod(Octopod octopod) {
        this.octopod = octopod;
    }
}
