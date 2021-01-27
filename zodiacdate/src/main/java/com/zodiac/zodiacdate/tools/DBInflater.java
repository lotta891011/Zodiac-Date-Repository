package com.zodiac.zodiacdate.tools;

import com.zodiac.zodiacdate.model.Hobby;
import com.zodiac.zodiacdate.model.Location;
import com.zodiac.zodiacdate.model.User;
import com.zodiac.zodiacdate.model.Zodiac;
import com.zodiac.zodiacdate.repositories.HobbyRepository;
import com.zodiac.zodiacdate.repositories.LocationRepository;
import com.zodiac.zodiacdate.repositories.UserRepository;
import com.zodiac.zodiacdate.repositories.ZodiacRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    public DBInflater(HobbyRepository hobbyRepository, LocationRepository locationRepository, UserRepository userRepository, ZodiacRepository zodiacRepository) {
        this.hobbyRepository = hobbyRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
        this.zodiacRepository = zodiacRepository;
    }

    private HobbyRepository hobbyRepository;
    private LocationRepository locationRepository;
    private UserRepository userRepository;
    private ZodiacRepository zodiacRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData(){

        User bob = new User("Boby", "Puncake", "28");
        Location orlando = new Location("Orlando","USA","Florida");
        Hobby cooking = new Hobby("Cooking","AtHome");
        Zodiac aquarius = new Zodiac("Aquarius","Air","Fixed");

        bob.setLocation(orlando);
        locationRepository.save(orlando);
        orlando.getUsersLoc().add(bob);
        userRepository.save(bob);
        bob.getHobbies().add(cooking);
        hobbyRepository.save(cooking);
        cooking.getUsers().add(bob);
        bob.setZodiac(aquarius);
        zodiacRepository.save(aquarius);
        aquarius.getUsersZod().add(bob);




        User lily = new User("Lily", "Debb", "27");
        Location tampa = new Location("Tampa", "USA", "Florida");
        Hobby cycling = new Hobby("Cycling", "Outside");
        Zodiac aries = new Zodiac("Aries", "Fire", "Cardinal");

        lily.setLocation(tampa);
        locationRepository.save(tampa);
        tampa.getUsersLoc().add(lily);
        userRepository.save(lily);
        lily.getHobbies().add(cycling);
        hobbyRepository.save(cycling);
        cycling.getUsers().add(lily);
        lily.setZodiac(aries);
        zodiacRepository.save(aries);
        aries.getUsersZod().add(lily);


    }
}
