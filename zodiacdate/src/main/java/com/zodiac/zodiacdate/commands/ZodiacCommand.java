package com.zodiac.zodiacdate.commands;

import com.zodiac.zodiacdate.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ZodiacCommand {
    private Long id;
    private String name;
    private String element;
    private String quality;
    private Set<User> users;
}
