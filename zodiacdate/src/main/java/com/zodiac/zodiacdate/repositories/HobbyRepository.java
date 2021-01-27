package com.zodiac.zodiacdate.repositories;

import com.zodiac.zodiacdate.model.Hobby;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HobbyRepository extends CrudRepository<Hobby, Long> {
    Optional<Hobby> getFirstByName(String name);
}
