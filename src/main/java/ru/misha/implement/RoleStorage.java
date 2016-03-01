package ru.misha.implement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.misha.interfaces.RoleDAO;
import ru.misha.model.Role;
import java.util.Collection;

@Repository
public class RoleStorage implements RoleDAO {


    private final HibernateTemplate template;

    @Autowired
    public RoleStorage(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public Collection<Role> getAll() {
        return (Collection<Role>) this.template.find("from Role");
    }

    @Transactional
    public int create(Role role) {
        return (int) this.template.save(role);
    }

    @Transactional
    public void update(Role role) {
        this.template.saveOrUpdate(role);
    }

    @Transactional
    public void delete(int id) {
        this.template.delete(template.get(Role.class, id));
    }

    @Override
    public Role getClientById(int id) {
        return this.template.get(Role.class, id);
    }

    public Collection<Role> getByName(String name) {
        return (Collection<Role>) this.template.find("from Role r where r.role = ?", name);
    }
}
