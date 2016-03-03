package ru.misha.implement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.misha.model.Message;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class MessageStorageTest {

    @Autowired
    Storages storages;


    @Test
    public void testCreate() throws Exception {

        Message message = new Message();
        message.setText("text");

        int id = storages.messageDAO.create(message);
        storages.messageDAO.delete(id);

    }
}