package com.octonauts.game.model.entity;

import com.octonauts.game.model.enums.AnimalType;
import com.octonauts.game.model.entity.sicknessFactory.Sickness;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "animals")
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private AnimalType type;
    @OneToOne(mappedBy = "animal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Sickness sickness;
    private LocalDateTime cureStarted;
    private LocalDateTime cureFinished;

    public Animal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public Sickness getSickness() {
        return sickness;
    }

    public void setSickness(Sickness sickness) {
        this.sickness = sickness;
    }

    public LocalDateTime getCureStarted() {
        return cureStarted;
    }

    public void setCureStarted(LocalDateTime cureStarted) {
        this.cureStarted = cureStarted;
    }

    public LocalDateTime getCureFinished() {
        return cureFinished;
    }

    public void setCureFinished(LocalDateTime cureFinished) {
        this.cureFinished = cureFinished;
    }
}
