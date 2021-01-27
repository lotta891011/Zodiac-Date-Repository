package com.zodiac.zodiacdate.repositories;

import com.zodiac.zodiacdate.model.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationRepository extends CrudRepository <Location, Long> {
    Optional<Location> getFirstById(Long id);
}

