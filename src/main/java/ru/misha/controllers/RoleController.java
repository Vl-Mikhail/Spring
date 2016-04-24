package ru.misha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.misha.implement.Storages;
import ru.misha.model.Client;
import ru.misha.model.Role;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@Controller
@RequestMapping("/admin")
public class RoleController {

    @Autowired
    private Storages storages;

    private Client client;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(ModelMap model, @RequestParam(value = "id") Integer id) {
        client = storages.clientDAO.getClientById(id);
        Role role = client.getRole();
        model.addAttribute("role", role);
        model.addAttribute("roles", storages.roleDAO.getAll());
        model.addAttribute("client", client);
        return "admin/show";
    }

    @RequestMapping(value = "/showNew")
    public String showNew(ModelMap model){
        Role role = client.getRole();
        model.addAttribute("role", role);
        model.addAttribute("roles", storages.roleDAO.getAll());
        return "admin/show";
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String saveRole(@RequestParam(value = "idRole") Integer id) {
        client.setRole(storages.roleDAO.getRoleById(id));
        storages.clientDAO.update(client);
        return "redirect:showNew";
    }
}
