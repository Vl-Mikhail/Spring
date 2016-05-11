package ru.misha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ru.misha.implement.Storages;
import ru.misha.model.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
    @RequestMapping(value = "/uploadFile")
    public String filePage(Model model ){
        return "/client/file";
    }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {

                byte[] fileBytes = file.getBytes();
                String rootPath = System.getProperty("catalina.home");
                System.out.println("Server rootPath: " + rootPath);
                System.out.println("File original name: " + file.getOriginalFilename());
                System.out.println("File content type: " + file.getContentType());

//                File newFile = new File(rootPath + File.separator + file.getOriginalFilename());
                File newFile = new File(rootPath + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
                stream.write(fileBytes);
                stream.close();

                System.out.println("File is saved under: " + rootPath + File.separator + file.getOriginalFilename());
                return "File is saved under: " + rootPath + File.separator + file.getOriginalFilename();

            } catch (Exception e) {
                e.printStackTrace();
                return "File upload is failed: " + e.getMessage();
            }
        } else {
            return "File upload is failed: File is empty";
        }
    }
}