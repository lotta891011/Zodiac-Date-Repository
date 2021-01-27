package com.zodiac.zodiacdate.commands;

import com.zodiac.zodiacdate.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class LocationCommand {
    private Long id;
    private String name;
    private String country;
    private String state;
    private Set<User> users;
}
