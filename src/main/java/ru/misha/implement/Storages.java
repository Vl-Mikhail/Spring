package ru.misha.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.misha.interfaces.*;

@Service
public class Storages {

    public final ClientDAO clientDAO;
    public final MessageDAO messageDAO;
    public final PetDAO petDAO;
    public final RoleDAO roleDAO;
    public final ImageDAO imageDAO;

    @Autowired
    public Storages(ClientDAO clientDAO, MessageDAO messageDAO, PetDAO petDAO, RoleDAO roleDAO, ImageDAO imageDAO) {
        this.clientDAO = clientDAO;
        this.messageDAO = messageDAO;
        this.petDAO = petDAO;
        this.roleDAO = roleDAO;
        this.imageDAO = imageDAO;
    }
}
