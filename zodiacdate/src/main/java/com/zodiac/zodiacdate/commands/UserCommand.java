package com.zodiac.zodiacdate.commands;

import com.zodiac.zodiacdate.model.Hobby;
import com.zodiac.zodiacdate.model.Location;
import com.zodiac.zodiacdate.model.Zodiac;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserCommand {
    private Long id;
    private String firstName;
    private String lastName;
    private String age;
    private Location location;
    private Zodiac zodiac;
    private Set<Hobby> hobbies;
}
