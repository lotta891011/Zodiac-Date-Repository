package com.zodiac.zodiacdate.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String age;

    @ManyToMany(mappedBy = "users")
    private Set<Hobby> hobbies = new HashSet<>();

    @ManyToOne
    private Location location;

    @ManyToOne
    private Zodiac zodiac;

    public User() {
    }

    public User(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.age = age;
    }

    public Location getLocation() { return location; }

    public void setLocation(Location location) { this.location = location; }

    public Zodiac getZodiac() {
        return zodiac;
    }

    public void setZodiac(Zodiac zodiac) {
        this.zodiac = zodiac;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", zodiac='" + zodiac + '\'' +
                ", location='" + location + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}
