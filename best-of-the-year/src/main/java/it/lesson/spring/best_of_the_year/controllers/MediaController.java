package it.lesson.spring.best_of_the_year.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class MediaController {
    
    @GetMapping
    public String bestOfTheYear(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "bestOfTheYear";
    } 
    

}
