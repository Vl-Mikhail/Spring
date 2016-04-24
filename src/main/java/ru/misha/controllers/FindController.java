package ru.misha.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.misha.implement.Storages;
import ru.misha.model.Client;
import ru.misha.model.Pet;

import java.util.Collection;
import java.util.Set;

@Controller
@RequestMapping(value = "/find")
public class FindController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String findClient(@RequestParam(value = "client") String name, ModelMap model) {

        if(storages.clientDAO.getByName(name).isEmpty()) {
            model.addAttribute("clients", storages.clientDAO.getAll());
            return "client/show";
        } else {
            storages.clientDAO.getByName(name);
            model.addAttribute("clients", storages.clientDAO.getByName(name));
            return "client/show";
        }
    }

    @RequestMapping(value = "/pet", method = RequestMethod.GET)
    public String findPet(@RequestParam(value = "pet") String name, ModelMap model) {
        model.addAttribute("clients", storages.clientDAO.getByName(name));
        return "client/show";

    }
}
