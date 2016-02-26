package ru.misha.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.misha.interfaces.ClientDAO;
import ru.misha.interfaces.MessageDAO;
import ru.misha.interfaces.RoleDAO;

@Service
public class Storages {

    public final ClientDAO clientDAO;
    public final MessageDAO messageDAO;
    public final PetStorage petStorage;
    public final RoleDAO roleDAO;

    @Autowired
    public Storages(ClientDAO clientDAO, MessageDAO messageDAO, PetStorage petStorage, RoleDAO roleDAO) {
        this.clientDAO = clientDAO;
        this.messageDAO = messageDAO;
        this.petStorage = petStorage;
        this.roleDAO = roleDAO;
    }
}
