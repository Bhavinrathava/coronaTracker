package com.BDev.CoronaTracker.controller;

import com.BDev.CoronaTracker.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class displayController {

    @Autowired
    DataService dtService;

    @GetMapping("/all")
    public String getMainPage(Model model)
    {
        model.addAttribute("repo",dtService.getList());
        System.out.println(dtService.getList().get(0));
        return "home";
    }
}
