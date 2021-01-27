package com.zodiac.zodiacdate.repositories;

import com.zodiac.zodiacdate.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> getFirstById(Long id);
}
