package com.zodiac.zodiacdate.converters;

import com.zodiac.zodiacdate.commands.UserCommand;
import com.zodiac.zodiacdate.model.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserCommandToUserConverter implements Converter <UserCommand, User> {

    @Nullable
    @Synchronized
    @Override
    public User convert(UserCommand source) {
      if(source == null) {
          return null;
      }
      final User user = new User();
      user.setAge(source.getAge());
      user.setLocation(source.getLocation());
      user.setZodiac(source.getZodiac());
      user.setFirstName(source.getFirstName());
      user.setLastName(source.getLastName());
      user.setHobbies(source.getHobbies());
      return user;
    }
}
