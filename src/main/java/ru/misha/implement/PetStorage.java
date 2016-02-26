package ru.misha.implement;


import org.springframework.stereotype.Repository;
import ru.misha.interfaces.PetDAO;
import ru.misha.model.Pet;

import java.util.Collection;

@Repository
public class PetStorage implements PetDAO {

    public Collection<Pet> getAll() {
        return null;
    }

    public int create(Pet pet) {
        return 0;
    }

    public void update(Pet pet) {

    }

    public void delete(int id) {

    }

    public void getByName(String name) {

    }
}
