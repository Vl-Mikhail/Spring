package ru.misha.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.misha.interfaces.PetDAO;
import ru.misha.model.Pet;

import java.util.Collection;

@Repository
public class PetStorage implements PetDAO {

    private final HibernateTemplate template;

    @Autowired
    public PetStorage(HibernateTemplate template) {
        this.template = template;
    }

    public Collection<Pet> getAll() {
        return (Collection<Pet>) this.template.find("from Pet");
    }

    @Transactional
    public int create(Pet pet) {
        return (int) this.template.save(pet);
    }

    @Transactional
    public void update(Pet pet) {
        this.template.saveOrUpdate(pet);
    }

    @Transactional
    public void delete(int id) {
        this.template.delete(template.get(Pet.class, id));
    }

    public Collection<Pet> getByName(String name) {
        return (Collection<Pet>) this.template.find("from Pet p where p.petName = ?", name);
    }

    @Override
    public Pet getPetById(int id) {
        return this.template.get(Pet.class, id);
    }
}
