package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Porsche;
import com.example.service.MobilService;
import com.example.service.PorscheService;

@Controller
@RequestMapping("/porsche") 
public class PorscheController {

    @Autowired
    private PorscheService porscheService;

    @Autowired
    private MobilService mobilService;


    @GetMapping
    public String welcome(Model model) {
        String messages = "welcome";
        model.addAttribute("msg", messages);
        model.addAttribute("porsches", porscheService.findAll());
        return "porsche/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("porsche", new Porsche());
        model.addAttribute("listMobil", mobilService.findAll());
        return "porsche/add";
    }

    @PostMapping("/save")
    public String save(Porsche porsche) {
        porscheService.addPorsche(porsche);
        return "redirect:/porsche"; 
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        porscheService.deleteById(id);
        return "redirect:/porsche"; 
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("porsche", porscheService.findById(id));
        model.addAttribute("listMobil", mobilService.findAll());
        return "porsche/edit";
    }

    @PostMapping("/update")
    public String update(Porsche porsche) {
        porscheService.updatePorsche(porsche);
        return "redirect:/porsche"; 
    }

}
