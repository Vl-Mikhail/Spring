package ru.misha.model;


public class Pet extends Base {

    private String petName;

    private int age;

    private Client client;

    public Pet() {
    }

    public Pet(String petName, int age) {
        this.petName = petName;
        this.age = age;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
