package ru.misha.implement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.misha.interfaces.RoleDAO;
import ru.misha.model.Role;
import java.util.Collection;

@Repository
public class RoleStorage implements RoleDAO {

    private SessionFactory factory;

    public RoleStorage() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public interface Command<T> {
        T pocess(Session session);
    }

    private <T> T transaction(final Command<T> command){
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try{
            return command.pocess(session);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public Collection<Role> getAll() {
        return null;
    }

    public int create(Role role) {
        return transaction((Session session) -> {
            session.save(role);
            return role.getId();
        });
    }

    public void update(Role role) {

    }

    public void delete(int id) {

    }

    public void getByName(String name) {

    }
}
