package ru.misha.interfaces;


import ru.misha.model.Client;

import java.util.Collection;

public interface ClientDAO extends StoragesCRUD<Client>{

    Client getClientById(int id);

    Client getClientByNameAndPW(String login, String password);
}
