package com.BDev.CoronaTracker.controller;

import com.BDev.CoronaTracker.models.record;
import com.BDev.CoronaTracker.services.DataService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class displayController {

    @Autowired
    DataService dtService;

    @GetMapping("/")
    public String getMainPage() {
        return "home";
    }

    @GetMapping("/all")
    public String getMainData() {
        ArrayList<record> resultList=dtService.getList();
        String  json =new Gson().toJson(resultList);
        System.out.println(json.substring(2,json.length()-2));
        return json.substring(2,json.length()-2);

    }

    @GetMapping("/search/{queryParam}")
    public String getSearchResult(@PathVariable String queryParam) {
        ArrayList<record> resultList=dtService.searchbyparam(queryParam);
        String json=new Gson().toJson(resultList);
        return json;
    }
}