package ru.misha.implement;


import org.springframework.stereotype.Repository;
import ru.misha.interfaces.ClientDAO;
import ru.misha.model.Client;

import java.util.Collection;

@Repository
public class ClientStorage implements ClientDAO{

    public Collection<Client> getAll() {
        return null;
    }

    public int create(Client client) {
        return 0;
    }

    public void update(Client client) {

    }

    public void delete(int id) {

    }

    public void getByName(String name) {

    }
}
