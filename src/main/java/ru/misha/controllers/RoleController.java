package ru.misha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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

    // По какому принципу добавляем новую запись?
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editRole(@ModelAttribute Role role, ModelMap modelMap) {
        storages.roleDAO.update(role);
        return "redirect:roles";
    }


    // По какому принципу добавляем новую запись?
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveRole(@ModelAttribute Role role, ModelMap modelMap) {
        storages.roleDAO.create(role);
        return "redirect:roles";
    }

}
