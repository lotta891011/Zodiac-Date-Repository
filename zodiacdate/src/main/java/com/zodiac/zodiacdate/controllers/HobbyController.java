package com.zodiac.zodiacdate.controllers;

import com.zodiac.zodiacdate.commands.HobbyCommand;
import com.zodiac.zodiacdate.converters.HobbyCommandToHobbyConverter;
import com.zodiac.zodiacdate.converters.HobbyToHobbyCommandConverter;
import com.zodiac.zodiacdate.model.Hobby;
import com.zodiac.zodiacdate.repositories.HobbyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class HobbyController {

    private HobbyRepository hobbyRepository;
    private HobbyCommandToHobbyConverter hobbyCommandToHobbyConverter;
    private HobbyToHobbyCommandConverter hobbyToHobbyCommandConverter;

    public HobbyController(HobbyCommandToHobbyConverter hobbyCommandToHobbyConverter, HobbyToHobbyCommandConverter hobbyToHobbyCommandConverter) {
        this.hobbyCommandToHobbyConverter = hobbyCommandToHobbyConverter;
        this.hobbyToHobbyCommandConverter = hobbyToHobbyCommandConverter;
    }

    @RequestMapping("/hobbies")
    public String getHobbies(Model model){
        model.addAttribute("hobbies", hobbyRepository.findAll());
        return "hobby/list";
    }
    @GetMapping
    @RequestMapping("/hobby/new")
    public String newHobby(Model model){
        model.addAttribute("hobby", new HobbyCommand());
        return "hobby/addedit";
    }
    @RequestMapping("/hobby/{id}/show")
    public String getHobbyDetails(Model model, @PathVariable("id") Long id){
        HobbyCommand editedHobby = hobbyToHobbyCommandConverter.convert(hobbyRepository.findById(id).get());
        model.addAttribute("hobby", editedHobby);
        return "hobby/show";
    }
    @RequestMapping("/hobby/{id}/delete")
    public String deleteHobby(@PathVariable("id") Long id) {
        hobbyRepository.deleteById(id);
        return "redirect:/hobbies";
    }
    @PostMapping("hobby")
    public String saveOrUpdate(@ModelAttribute HobbyCommand command){

        Optional<Hobby> hobbyOptional = hobbyRepository.getFirstByName(command.getName());

        if (!hobbyOptional.isPresent()) {
            Hobby detachedHobby = hobbyCommandToHobbyConverter.convert(command);
            Hobby savedHobby = hobbyRepository.save(detachedHobby);
            return "redirect:/hobby/" + savedHobby.getId() + "/show";
        } else {
            System.out.println("Sorry, there's such hobby in db");
            return "redirect:/hobby/" + hobbyOptional.get().getId() + "/show";
        }
    }
}
