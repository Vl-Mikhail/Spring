package ru.misha.implement;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.misha.model.Client;
import ru.misha.model.Pet;
import ru.misha.model.Role;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class ClientStorageTest {

    @Autowired
    Storages storages;

    @Test
//    @Ignore
    public void testCreate() throws Exception {

        Pet pet = new Pet();
        Role role = new Role();
        Client client = new Client();

        role.setRole("test");

        client.setLogin("login");
        client.setEmail("@mail");
        client.setPassword("123");
        client.setRole(role);
        int id = storages.clientDAO.create(client);

        pet.setPetName("cat");
        pet.setClient(client);
        storages.petDAO.create(pet);

        client.getPets().add(pet);

        System.out.println(storages.clientDAO.getClientById(id));

        client.setLogin("log");
        storages.clientDAO.update(client);
        System.out.println(storages.clientDAO.getClientById(id));

        System.out.println(storages.clientDAO.getClientByNameAndPW("Mike", "12345"));


    }
}