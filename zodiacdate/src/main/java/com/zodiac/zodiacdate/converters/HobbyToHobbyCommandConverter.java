package com.zodiac.zodiacdate.converters;

import com.zodiac.zodiacdate.commands.HobbyCommand;
import com.zodiac.zodiacdate.model.Hobby;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class HobbyToHobbyCommandConverter implements Converter<Hobby, HobbyCommand> {
    @Nullable
    @Synchronized
    @Override
    public HobbyCommand convert(Hobby source) {
       if (source == null){
           return null;
       }
       final HobbyCommand hobbyCommand = new HobbyCommand();
       hobbyCommand.setName(source.getName());
       hobbyCommand.setType(source.getType());
       hobbyCommand.setUsers(source.getUsers());
       return hobbyCommand;
    }
}
