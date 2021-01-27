package com.zodiac.zodiacdate.converters;

import com.zodiac.zodiacdate.commands.HobbyCommand;
import com.zodiac.zodiacdate.model.Hobby;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class HobbyCommandToHobbyConverter implements Converter< HobbyCommand, Hobby> {
    @Nullable
    @Synchronized
    @Override
    public Hobby convert(HobbyCommand source) {
        if (source == null){
            return null;
        }
        final Hobby hobby = new Hobby();
        hobby.setName(source.getName());
        hobby.setType(source.getType());
        hobby.setUsers(source.getUsers());
        return hobby;
    }
}
