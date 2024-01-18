package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Mobil;
import com.example.service.MobilService;

@Controller
@RequestMapping("")
public class HomeController {
    
    @Autowired
    private MobilService mobilService;

    @GetMapping
    public String welcome(Model model){
        String messages = "welcome";
        model.addAttribute("msg", messages);
        model.addAttribute("mobils", mobilService.findAll());
        return "mobil/index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("mobil", new Mobil());
        return "mobil/add";
    }

    @PostMapping("/save")
    public String save(Mobil mobil){
        mobilService.addMobil(mobil);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id){
        mobilService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute("mobil", mobilService.findById(id));
        return "mobil/edit";
    }

    @PostMapping("/update")
    public String update(Mobil mobil){
        mobilService.updateMobil(mobil);
        return "redirect:/";
    }
}
