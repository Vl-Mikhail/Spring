package ru.misha.interfaces;


import java.util.Collection;

public interface StoragesCRUD<T> {

    Collection<T> getAll();

    int create(T t);

    void update(T t);

    void delete(int id);

    void getByName(String name);

}
