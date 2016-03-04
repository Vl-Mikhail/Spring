package ru.misha.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.misha.interfaces.MessageDAO;
import ru.misha.model.Message;

import java.util.Collection;

@Repository
public class MessageStorage implements MessageDAO{

    private final HibernateTemplate template;

    @Autowired
    public MessageStorage(HibernateTemplate template) {
        this.template = template;
    }

    public Collection<Message> getAll() {
        return (Collection<Message>) this.template.find("from Message");
    }

    @Transactional
    public int create(Message message) {
        return (int) this.template.save(message);
    }

    @Transactional
    public void update(Message message) {
        this.template.saveOrUpdate(message);
    }

    @Transactional
    public void delete(int id) {
        this.template.delete(template.get(Message.class, id));
    }

    @Override
    public Message getClientById(int id) {
        return this.template.get(Message.class, id);
    }

    public Collection<Message> getByName(String name) {
        return (Collection<Message>) this.template.find("from Message m where m.text = ?", name);
    }
}
