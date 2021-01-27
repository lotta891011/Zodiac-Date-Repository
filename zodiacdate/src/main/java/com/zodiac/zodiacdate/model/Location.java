package com.zodiac.zodiacdate.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String country;
    private String state;

    @OneToMany(mappedBy = "location")
    private Set<User> usersLoc = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String city) { this.state = city; }

    public Set<User> getUsersLoc() {return usersLoc;}

    public void setUsersLoc(Set<User> users) {this.usersLoc = users;}


    public Location(String name, String country, String state) {
        this.name = name;
        this.country = country;
        this.state = state;
    }

    public Location() {
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + state + '\'' +
                '}';
    }
}
