package ru.misha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.misha.implement.Storages;
import ru.misha.model.Client;
import ru.misha.model.Pet;

import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private Storages storages;

    private Client client;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showPet(@RequestParam(value = "id") Integer id, ModelMap model) {
        client = storages.clientDAO.getClientById(id);
        Set<Pet> pets = client.getPets();
        model.addAttribute("pets", pets);
        model.addAttribute("client", client);
        model.addAttribute("id", id);
        return "pet/show";
    }

    @RequestMapping(value = "/showNew")
    public String showNew(ModelMap model){
        Set<Pet> pets = client.getPets();
        model.addAttribute("pets", pets);
        model.addAttribute("client", client);
        return "pet/show";
    }

    //Не совсем коректно работает
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id) {
        Pet pet = storages.petDAO.getPetById(id);
        storages.petDAO.delete(id);
        client.getPets().remove(pet);
        return "redirect:showNew";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute Pet pet) {

        pet.setClient(client);
        storages.petDAO.create(pet);
        client.getPets().add(pet);

        return "redirect:showNew";
    }
}
