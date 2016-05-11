package ru.misha.interfaces;

import ru.misha.model.Pet;

public interface PetDAO extends StoragesCRUD<Pet>{

    Pet getPetById(int id);

}
