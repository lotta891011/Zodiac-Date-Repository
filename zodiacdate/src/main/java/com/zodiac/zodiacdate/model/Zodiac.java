package com.zodiac.zodiacdate.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Zodiac {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String element;
    private String quality;

   @OneToMany(mappedBy = "zodiac")
   private Set<User> usersZod = new HashSet<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Set<User> getUsersZod() {return usersZod;}

    public void setUsersZod(Set<User> users) {this.usersZod = users;}

    public Zodiac(String name, String element, String quality) {
        this.name = name;
        this.element = element;
        this.quality = quality;
    }

    public Zodiac() {
    }

    @Override
    public String toString() {
        return "Zodiac{" +
                ", name='" + name + '\'' +
                ", element='" + element + '\'' +
                ", quality='" + quality + '\'' +
                ", users=" + usersZod +
                '}';
    }
}
