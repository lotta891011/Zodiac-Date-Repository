package com.zodiac.zodiacdate.converters;

import com.zodiac.zodiacdate.commands.LocationCommand;
import com.zodiac.zodiacdate.model.Location;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class LocationCommandToLocationConverter implements Converter<LocationCommand, Location> {
    @Nullable
    @Synchronized
    @Override
    public Location convert(LocationCommand source) {
        if (source == null) {
            return null;
        }
        final Location location = new Location();
        location.setName(source.getName());
        location.setCountry(source.getCountry());
        location.setUsersLoc(source.getUsers());
        location.setState(source.getState());
        return location;
    }
}
