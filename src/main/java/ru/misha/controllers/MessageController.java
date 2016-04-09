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

    private static Client client;

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showPet(@RequestParam(value = "id") Integer id, ModelMap model) {
        Set<Message> messages = storages.clientDAO.getClientById(id).getMessages();
        model.addAttribute("messages", messages);
        //Получаем клиента что бы в дальнейшем его использовать
        client = storages.clientDAO.getClientById(id);
        model.addAttribute("client", client);
        return "message/show";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "id") Integer id) {
        storages.messageDAO.delete(id);
        return "redirect:client/show";
        //return "client/show"; идет переадресация но странице не получает клиентов из базы
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute Message message) {

        int id = storages.messageDAO.create(message);
        Set<Message> messages = new HashSet<>();
        messages.add(storages.messageDAO.getClientById(id)); //тут передается животное а не клиент, не правино написал интерфейс
        client.setMessages(messages);

        return "redirect:client/show";

        //Ругается что в таблице не user_id не может быть null
        //Хотя тут он прописан <input type="hidden" name="${client.id}" placeholder="Имя Клиента">
    }


}
