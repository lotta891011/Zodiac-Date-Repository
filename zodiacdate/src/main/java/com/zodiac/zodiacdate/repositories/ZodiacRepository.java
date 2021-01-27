package com.zodiac.zodiacdate.repositories;

import com.zodiac.zodiacdate.model.Zodiac;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ZodiacRepository extends CrudRepository <Zodiac, Long> {
    Optional<Zodiac> getFirstById(Long id);
}

