package ru.misha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.misha.implement.Storages;

@Controller
public class HomeController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showRole(ModelMap model) {
        model.addAttribute("clients", storages.clientDAO.getAll());
        return "index";
    }

}
