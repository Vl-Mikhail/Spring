package ru.misha.implement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.misha.model.Pet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class PetStorageTest {

    @Autowired
    Storages storages;

    @Test
    public void create() throws Exception {
        Pet pet = new Pet();
        pet.setPetName("Cat1");
        pet.setAge(5);

        int id = storages.petDAO.create(pet);
        System.out.println(id);
        storages.petDAO.delete(id);



    }
}