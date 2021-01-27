package com.zodiac.zodiacdate.converters;

import com.zodiac.zodiacdate.commands.ZodiacCommand;
import com.zodiac.zodiacdate.model.Zodiac;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ZodiacCommandToZodiacConverter implements Converter<ZodiacCommand, Zodiac > {

    @Synchronized
    @Nullable
    @Override
    public Zodiac convert(ZodiacCommand source) {
        if (source == null) {
            return null;
        }
        final Zodiac zodiac = new Zodiac();
        zodiac.setName(source.getName());
        zodiac.setElement(source.getElement());
        zodiac.setQuality(source.getQuality());
        return zodiac;
    }
}


