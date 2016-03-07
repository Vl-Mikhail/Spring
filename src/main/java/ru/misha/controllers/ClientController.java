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
    public String showRole(ModelMap model) {
        model.addAttribute("clients", storages.clientDAO.getAll());
        return "client/show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteRole(@RequestParam(value = "id") Integer id) {
        storages.clientDAO.delete(id);
        return "redirect:show";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editRole(@RequestParam(value = "id") Integer id, ModelMap model){
        model.addAttribute("role", storages.clientDAO.getClientById(id));
        return "client/edit";
    }

    // По какому принципу добавляем новую запись?
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editRole(@ModelAttribute Client client, ModelMap modelMap) {
        storages.clientDAO.update(client);
        return "redirect:show";
    }


    // По какому принципу добавляем новую запись?
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveRole(@ModelAttribute Client client) {
        storages.clientDAO.create(client);


        return "redirect:show";
    }

    //bootstrap - таблица стилий


}
