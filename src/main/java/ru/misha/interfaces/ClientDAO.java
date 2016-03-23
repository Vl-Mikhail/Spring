package ru.misha.interfaces;


import ru.misha.model.Client;

public interface ClientDAO extends StoragesCRUD<Client>{

    Client getClientByNameAndPW(String login, String password);
}
