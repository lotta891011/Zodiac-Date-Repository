package com.zodiac.zodiacdate.controllers;

import com.zodiac.zodiacdate.commands.HobbyCommand;
import com.zodiac.zodiacdate.commands.LocationCommand;
import com.zodiac.zodiacdate.converters.LocationCommandToLocationConverter;
import com.zodiac.zodiacdate.converters.LocationToLocationCommandConverter;
import com.zodiac.zodiacdate.model.Hobby;
import com.zodiac.zodiacdate.model.Location;
import com.zodiac.zodiacdate.repositories.LocationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LocationController {
    LocationRepository locationRepository;
    LocationToLocationCommandConverter locationToLocationCommandConverter;
    LocationCommandToLocationConverter locationCommandToLocationConverter;

    public LocationController(LocationToLocationCommandConverter locationToLocationCommandConverter, LocationCommandToLocationConverter locationCommandToLocationConverter) {
        this.locationToLocationCommandConverter = locationToLocationCommandConverter;
        this.locationCommandToLocationConverter = locationCommandToLocationConverter;
    }

    @RequestMapping("/locations")
    public String getLocations(Model model){
        model.addAttribute("locations", locationRepository.findAll());
        return "location/list";
    }

    @GetMapping
    @RequestMapping("/location/new")
    public String newLocation(Model model){
        model.addAttribute("location", new LocationCommand());
        return "location/addedit";
    }
   @RequestMapping("/location/{id}/show")
   public String getLocationDetails(Model model, @PathVariable("id") Long id){
       LocationCommand editedLocation = locationToLocationCommandConverter.convert(locationRepository.findById(id).get());
       model.addAttribute("location", editedLocation);
       return "location/show";
   }
    @RequestMapping("/location/{id}/delete")
    public String deleteLocation(@PathVariable("id") Long id) {
        locationRepository.deleteById(id);
        return "redirect:/locations";
    }
    @PostMapping("location")
    public String saveOrUpdate(@ModelAttribute LocationCommand command){

        Optional<Location> locationOptional = locationRepository.getFirstById(command.getId());

        if (!locationOptional.isPresent()) {
            Location detachedLocation = locationCommandToLocationConverter.convert(command);
            Location savedLocation = locationRepository.save(detachedLocation);
            return "redirect:/location/" + savedLocation.getId() + "/show";
        } else {
            System.out.println("Sorry, there's such location in db");
            return "redirect:/location/" + locationOptional.get().getId() + "/show";
        }
    }
}
