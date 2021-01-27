package com.zodiac.zodiacdate.converters;

import com.zodiac.zodiacdate.commands.ZodiacCommand;
import com.zodiac.zodiacdate.model.Zodiac;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ZodiacToZodiacCommandConverter implements Converter<Zodiac, ZodiacCommand> {

    @Synchronized
    @Nullable
    @Override
    public ZodiacCommand convert(Zodiac source) {
        if (source == null) {
            return null;
        }
        final ZodiacCommand zodiacCommand = new ZodiacCommand();
        zodiacCommand.setName(source.getName());
        zodiacCommand.setElement(source.getElement());
        zodiacCommand.setQuality(source.getQuality());
        return zodiacCommand;
    }
}
