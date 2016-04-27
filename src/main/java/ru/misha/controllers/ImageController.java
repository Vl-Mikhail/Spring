package ru.misha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.misha.implement.Storages;
import ru.misha.model.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private Storages storages;

    @RequestMapping(value = "/display")
    public void showImage(@RequestParam("id") Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        Client client = storages.clientDAO.getClientById(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(client.getImage());

        response.getOutputStream().close();
    }
}