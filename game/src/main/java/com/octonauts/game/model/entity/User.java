package com.octonauts.game.model.entity;

import javax.persistence.*;

@Table(name = "users")
@Entity
public class User  implements Comparable<User>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private int points;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Octopod octopod;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Octopod getOctopod() {
        return octopod;
    }

    public void setOctopod(Octopod octopod) {
        this.octopod = octopod;
    }

    @Override
    public int compareTo(User user) {
        return this.points - user.points;
    }
}
