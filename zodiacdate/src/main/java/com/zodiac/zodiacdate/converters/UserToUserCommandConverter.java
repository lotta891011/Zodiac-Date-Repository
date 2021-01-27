package com.zodiac.zodiacdate.converters;

import com.zodiac.zodiacdate.commands.UserCommand;
import com.zodiac.zodiacdate.model.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCommandConverter implements Converter<User, UserCommand> {

    @Nullable
    @Synchronized
    @Override
    public UserCommand convert(User source) {
        if (source == null) {
            return null;
        }
        final UserCommand userCommand = new UserCommand();
        userCommand.setAge(source.getAge());
        userCommand.setFirstName(source.getFirstName());
        userCommand.setLastName(source.getLastName());
        userCommand.setLocation(source.getLocation());
        userCommand.setZodiac(source.getZodiac());
        userCommand.setHobbies(source.getHobbies());
        return userCommand;
    }

}