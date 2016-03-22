package ru.misha.implement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.misha.model.Client;
import ru.misha.model.Role;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class ClientStorageTest {

    @Autowired
    Storages storages;

    @Test
    public void testCreate() throws Exception {



        Role role = new Role();
        role.setRole("test");

        Client client = new Client();
        client.setLogin("login");
        client.setEmail("@mail");
        client.setRole(role);

        int id = storages.clientDAO.create(client);
        System.out.println(storages.clientDAO.getClientById(id));

        client.setLogin("log");
        storages.clientDAO.update(client);
        System.out.println(storages.clientDAO.getClientById(id));




    }
}