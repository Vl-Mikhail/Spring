package ru.misha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.misha.implement.Storages;
import ru.misha.model.Pet;
import java.util.Set;


@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showPet(@RequestParam(value = "id") Integer id, ModelMap model) {
        Set<Pet> pets = storages.clientDAO.getClientById(id).getPets();
        model.addAttribute("pets", pets);
        return "pet/show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id, ModelMap model) {

        return "pet/show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id") Integer id, ModelMap model) {

        return "pet/show";
    }

}
