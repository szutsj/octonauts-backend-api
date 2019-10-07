package com.octonauts.game.model.entity;

import com.octonauts.game.model.entity.Octopod;
import com.octonauts.game.model.enums.CrewMembers;

import javax.persistence.*;

@Table(name = "crewMembers")
@Entity
public class CrewMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private CrewMembers name;
    private boolean active;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "octopods_id")
    private Octopod octopod;

    public CrewMember() {
    }

    public CrewMember(CrewMembers name, boolean active, Octopod octopod) {
        this.name = name;
        this.active = active;
        this.octopod = octopod;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CrewMembers getName() {
        return name;
    }

    public void setName(CrewMembers name) {
        this.name = name;
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
