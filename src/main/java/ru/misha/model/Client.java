package ru.misha.model;

import java.util.Set;


public class Client extends Base {
    private String login;
    private String email;
    private String password;
    private Role role; // У одной роли, могут быть много пользователей
    private Set<Message> messages; // Список сообщений
    private Set<Pet> pets;
    private byte[] image;

    public Client() {
    }

    public Client(final int id, final String login, final String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public Client(final int id, String login, String password, Set<Message> messages) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.messages = messages;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public String getLogin() {
        return this.login;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Client{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", messages=" + messages +
                ", pets=" + pets +
                '}';
    }
}