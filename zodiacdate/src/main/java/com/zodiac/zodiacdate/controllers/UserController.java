package com.zodiac.zodiacdate.controllers;

import com.zodiac.zodiacdate.commands.UserCommand;
import com.zodiac.zodiacdate.converters.UserCommandToUserConverter;
import com.zodiac.zodiacdate.converters.UserToUserCommandConverter;
import com.zodiac.zodiacdate.model.User;
import com.zodiac.zodiacdate.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    private UserRepository userRepository;
    private UserCommandToUserConverter userCommandToUserConverter;
    private UserToUserCommandConverter userToUserCommandConverter;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }


    @GetMapping
    @RequestMapping("/user/new")
    public String newUser(Model model){
        model.addAttribute("user",new UserCommand());
        return "user/addedit";
    }

    @RequestMapping("/user/{id}/show")
    public String getUserDetails(Model model, @PathVariable("id") Long id){
        UserCommand editedUser = userToUserCommandConverter.convert(userRepository.findById(id).get());
        model.addAttribute("user", editedUser);
        return "user/show";
    }
    @RequestMapping("/user/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }
    @PostMapping("user")
    public String saveOrUpdate(@ModelAttribute UserCommand command){

        Optional<User> userOptional = userRepository.getFirstById(command.getId());

        if (!userOptional.isPresent()) {
            User detachedUser = userCommandToUserConverter.convert(command);
            User savedUser = userRepository.save(detachedUser);
            return "redirect:/user/" + savedUser.getId() + "/show";
        } else {
            System.out.println("Sorry, there's such user in db");
            return "redirect:/user/" + userOptional.get().getId() + "/show";
        }
    }
}
