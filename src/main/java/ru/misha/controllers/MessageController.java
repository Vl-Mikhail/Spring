package ru.misha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.misha.implement.Storages;
import ru.misha.model.Message;
import ru.misha.model.Pet;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showPet(@RequestParam(value = "id") Integer id, ModelMap model) {
        Set<Message> messages = storages.clientDAO.getClientById(id).getMessages();
        model.addAttribute("messages", messages);
        model.addAttribute("client", storages.clientDAO.getClientById(id));
        return "message/show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id) {
        storages.messageDAO.delete(id);
        return "redirect:show";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute Message message) {
        int petId = storages.messageDAO.create(message);
        Set<Message> messages = new HashSet<>();
        messages.add(message);

        return "redirect:show";
    }


}
