package ru.misha.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.misha.interfaces.ClientDAO;
import ru.misha.model.Client;

import java.util.Collection;
import java.util.List;

@Repository
public class ClientStorage implements ClientDAO{

    private final HibernateTemplate template;

    @Autowired
    public ClientStorage(HibernateTemplate template) {
        this.template = template;
    }


    public Collection<Client> getAll() {
        return (Collection<Client>) this.template.find("from Client");
    }

    @Transactional
    public int create(Client client) {
        return (int) this.template.save(client);
    }

    @Transactional
    public void update(Client client) {
        this.template.update(client);
    }

    @Transactional
    public void delete(int id) {
        this.template.delete(template.get(Client.class, id));
    }

    @Override
    public Client getClientById(int id) {
        return this.template.get(Client.class, id);
    }

    @Override
    public Collection<Client> getClientByNamePet(String name) {
        return null;
    }

    public Collection<Client> getByName(String name) {
        return (Collection<Client>) this.template.find("from Client c where c.login = ?", name);
    }

    @Override
    public Client getClientByNameAndPW(String login, String password) {
        List<Client> clients = (List<Client>) this.template.find("from Client c where c.login = ? and c.password = ?", login, password);
        return clients.isEmpty() ? null : clients.iterator().next();
    }


}
