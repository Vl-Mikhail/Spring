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
import ru.misha.model.Message;
import ru.misha.model.Pet;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private Storages storages;

    Client client;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showPet(@RequestParam(value = "id") Integer id, ModelMap model) {
        client = storages.clientDAO.getClientById(id);
        Set<Message> messages = client.getMessages();
        model.addAttribute("messages", messages);
        model.addAttribute("client", client);
        return "message/show";
    }

    @RequestMapping(value = "/showNew")
    public String showNew(ModelMap model){
        Set<Message> messages = client.getMessages();
        model.addAttribute("messages", messages);
        model.addAttribute("client", client);
        return "message/show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id) {
        Message message = storages.messageDAO.getMessageById(id);
        storages.messageDAO.delete(id);
        client.getMessages().remove(message);
        return "redirect:showNew";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute Message message) {
        message.setClient(client);
        storages.messageDAO.create(message);
        client.getMessages().add(message);
        return "redirect:showNew";
    }


}
