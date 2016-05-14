package ru.misha.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.misha.implement.Storages;
import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showRole(ModelMap model) {
        model.addAttribute("clients", storages.clientDAO.getAll());
        return "index";
    }

    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public @ResponseBody String ajax() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(storages.clientDAO.getAll());
        return mapper.writeValueAsString(storages.clientDAO.getAll());
//        return mapper.writeValueAsString(new Client(1, "Mike", "email"));
    }
}
