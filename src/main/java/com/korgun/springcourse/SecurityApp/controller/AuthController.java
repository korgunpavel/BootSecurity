package com.korgun.springcourse.SecurityApp.controller;

import com.korgun.springcourse.SecurityApp.models.Person;
import com.korgun.springcourse.SecurityApp.services.RegistrationService;
import com.korgun.springcourse.SecurityApp.util.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;
    private final PersonValidator personValidator;

    @Autowired
    public AuthController(RegistrationService registrationService, PersonValidator personValidator) {
        this.registrationService = registrationService;
        this.personValidator = personValidator;
    }

    @GetMapping("/login")
    public String login(){
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        personValidator.validate(person, bindingResult);
        if(bindingResult.hasErrors()) return "auth/registration";
        registrationService.register(person);
        return "redirect:/auth/login";
    }
}
