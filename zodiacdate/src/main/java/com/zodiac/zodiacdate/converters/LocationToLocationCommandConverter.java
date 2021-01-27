package com.zodiac.zodiacdate.converters;

import com.zodiac.zodiacdate.commands.LocationCommand;
import com.zodiac.zodiacdate.model.Location;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class LocationToLocationCommandConverter implements Converter<Location, LocationCommand> {

    @Nullable
    @Synchronized
    @Override
    public LocationCommand convert(Location source) {
        if (source == null) {
            return null;
        }
        final LocationCommand locationCommand = new LocationCommand();
        locationCommand.setName(source.getName());
        locationCommand.setCountry(source.getCountry());
        locationCommand.setUsers(source.getUsersLoc());
        locationCommand.setState(source.getState());

        return locationCommand;
    }

}