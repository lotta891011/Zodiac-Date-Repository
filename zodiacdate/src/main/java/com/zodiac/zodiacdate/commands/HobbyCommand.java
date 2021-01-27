package com.zodiac.zodiacdate.commands;

import com.zodiac.zodiacdate.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class HobbyCommand {
    private Long id;
    private String name;
    private String type;
    private Set<User> users;
}
