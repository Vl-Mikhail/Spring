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

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showPet(@RequestParam(value = "id") Integer id, ModelMap model) {
        Set<Pet> pets = storages.clientDAO.getClientById(id).getPets();
        model.addAttribute("pets", pets);
        model.addAttribute("client", storages.clientDAO.getClientById(id));
        model.addAttribute("id", id);
        return "pet/show";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer idPet) {
        storages.petDAO.delete(idPet);
        return "redirect:client/show";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute Pet pet) {
        int petId = storages.petDAO.create(pet);
//        Set<Pet> pets = new HashSet<>();
//        pets.add(pet);
//        Client client = storages.clientDAO.getClientById(id);
//        client.setPets(pets);

        return "redirect:show";
    }
}
