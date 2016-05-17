package ru.misha.model;

import org.codehaus.jackson.annotate.JsonManagedReference;

import java.util.Set;


public class Client extends Base {
    private String login;
    private String email;
    private String password;
    private Role role; // У одной роли, могут быть много пользователей

    @JsonManagedReference
    private Set<Message> messages; // Список сообщений

    @JsonManagedReference
    private Set<Pet> pets;

    @JsonManagedReference
    private Set<Image> images;

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

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }


}