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
import ru.misha.model.Role;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showClient(ModelMap model) {
        model.addAttribute("clients", storages.clientDAO.getAll());
        model.addAttribute("roles", storages.roleDAO.getAll());
        return "client/show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteClient(@RequestParam(value = "id") Integer id) {
        storages.clientDAO.delete(id);
        return "redirect:show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editClient(@RequestParam(value = "id") Integer id, ModelMap model){
        model.addAttribute("client", storages.clientDAO.getClientById(id));
        model.addAttribute("roles", storages.roleDAO.getAll());
        return "client/edit";
    }

    //Не работает метод
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editClient(@ModelAttribute("client") Client client, ModelMap modelMap) {
        storages.clientDAO.update(client);

        return "redirect:show";
    }


    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute Client client) {

        storages.clientDAO.create(client);
        return "redirect:show";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findClient(@RequestParam(value = "findName") String name, ModelMap model) {

        if(storages.clientDAO.getByName(name).isEmpty()) {
            model.addAttribute("clients", storages.clientDAO.getAll());
            return "client/show";
        } else {
            storages.clientDAO.getByName(name);
            model.addAttribute("clients", storages.clientDAO.getByName(name));
            return "client/show";
        }
    }

}
