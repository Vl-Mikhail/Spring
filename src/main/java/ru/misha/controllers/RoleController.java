package ru.misha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.misha.implement.Storages;
import ru.misha.model.Role;

@Controller
@RequestMapping("/admin")
public class RoleController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public String showRole(ModelMap model) {
        model.addAttribute("roles", storages.roleDAO.getAll());
        return "Roles";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteRole(@PathVariable int id, ModelMap modelMap) {
        storages.roleDAO.delete(id);
        return "redirect:roles";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveRole(@ModelAttribute Role role, ModelMap modelMap) {
        storages.roleDAO.create(role);
        return "redirect:roles";
    }

}
