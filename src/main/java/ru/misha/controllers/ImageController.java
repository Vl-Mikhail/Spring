package ru.misha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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

    Client client;

    @RequestMapping(value = "/display")
    public void showImage(@RequestParam("id") Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        client = storages.clientDAO.getClientById(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(client.getImage());

        response.getOutputStream().close();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(@RequestParam("id") Integer id){
        client = storages.clientDAO.getClientById(id);
        return "/client/file";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();

        storages.clientDAO.create(client);
        return null;
    }
}