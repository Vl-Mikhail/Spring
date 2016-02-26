package ru.misha.implement;


import org.springframework.stereotype.Repository;
import ru.misha.interfaces.MessageDAO;
import ru.misha.model.Message;

import java.util.Collection;

@Repository
public class MessageStorage implements MessageDAO{
    public Collection<Message> getAll() {
        return null;
    }

    public int create(Message message) {
        return 0;
    }

    public void update(Message message) {

    }

    public void delete(int id) {

    }

    public void getByName(String name) {

    }
}
