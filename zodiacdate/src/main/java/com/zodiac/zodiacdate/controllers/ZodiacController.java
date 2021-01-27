package com.zodiac.zodiacdate.controllers;

import com.zodiac.zodiacdate.commands.ZodiacCommand;
import com.zodiac.zodiacdate.converters.ZodiacCommandToZodiacConverter;
import com.zodiac.zodiacdate.converters.ZodiacToZodiacCommandConverter;
import com.zodiac.zodiacdate.model.Zodiac;
import com.zodiac.zodiacdate.repositories.ZodiacRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ZodiacController {
    private ZodiacRepository zodiacRepository;
    private ZodiacCommandToZodiacConverter zodiacCommandToZodiacConverter;
    private ZodiacToZodiacCommandConverter zodiacToZodiacCommandConverter;

    public ZodiacController(ZodiacRepository zodiacRepository, ZodiacCommandToZodiacConverter zodiacCommandToZodiacConverter, ZodiacToZodiacCommandConverter zodiacToZodiacCommandConverter) {
        this.zodiacRepository = zodiacRepository;
        this.zodiacCommandToZodiacConverter = zodiacCommandToZodiacConverter;
        this.zodiacToZodiacCommandConverter = zodiacToZodiacCommandConverter;
    }

    @RequestMapping("/zodiacs")
    public String getZodiacs(Model model){
        model.addAttribute("zodiacs", zodiacRepository.findAll());
        return "zodiac/list";
    }
    @GetMapping
    @RequestMapping("/zodiac/new")
    public String newZodiac(Model model){
        model.addAttribute("zodiac", new ZodiacCommand());
        return "zodiac/addedit";
    }

    @RequestMapping("/zodiac/{id}/show")
    public String getZodiacDetails(Model model, @PathVariable("id") Long id){
        ZodiacCommand editedZodiac = zodiacToZodiacCommandConverter.convert(zodiacRepository.findById(id).get());
        model.addAttribute("zodiac", editedZodiac);
        return "zodiac/show";
    }
    @RequestMapping("/zodiac/{id}/delete")
    public String deleteZodiac(@PathVariable("id") Long id) {
        zodiacRepository.deleteById(id);
        return "redirect:/zodiacs";
    }
    @PostMapping("zodiac")
    public String saveOrUpdate(@ModelAttribute ZodiacCommand command){

        Optional<Zodiac> zodiacOptional = zodiacRepository.getFirstById(command.getId());

        if (!zodiacOptional.isPresent()) {
            Zodiac detachedZodiac = zodiacCommandToZodiacConverter.convert(command);
            Zodiac savedZodiac = zodiacRepository.save(detachedZodiac);
            return "redirect:/zodiac/" + savedZodiac.getId() + "/show";
        } else {
            System.out.println("Sorry, there's such zodiac sign in db");
            return "redirect:/zodiac/" + zodiacOptional.get().getId() + "/show";
        }
    }
}
