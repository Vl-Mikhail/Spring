package ru.misha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.misha.implement.Storages;
import ru.misha.model.Role;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@Controller
@RequestMapping("/admin")
public class RoleController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(ModelMap model, @RequestParam(value = "id") Integer id) {
        Role role = storages.clientDAO.getClientById(id).getRole();
        model.addAttribute("role", role);
        model.addAttribute("roles", storages.roleDAO.getAll());
        return "admin/show";
    }


    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String showRole(ModelMap model) {
        model.addAttribute("roles", storages.roleDAO.getAll());
        return "admin/roles";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteRole(@RequestParam(value = "id") Integer id) {
        storages.roleDAO.delete(id);
        return "redirect:roles";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editRole(@RequestParam(value = "id") Integer id, ModelMap model){
        model.addAttribute("role", storages.roleDAO.getClientById(id));
        return "admin/edit";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editRole(@ModelAttribute Role role, ModelMap modelMap) {
        storages.roleDAO.update(role);
        return "redirect:roles";
    }


    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveRole(@ModelAttribute("role") Role role, ModelMap modelMap) {
        storages.roleDAO.create(role);
        return "redirect:roles";
    }

    @RequestMapping(value = "/text", method = RequestMethod.GET)
    public String textRole(ModelMap modelMap) {
        try(Writer write = new FileWriter("C:\\TMP\\text.txt", true)) {
            for (Role i : storages.roleDAO.getAll()) {
                write.write(i.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:roles";
    }
}
