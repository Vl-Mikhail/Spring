package ru.misha.model;


import org.codehaus.jackson.annotate.JsonBackReference;

public class Message extends Base{

    @JsonBackReference
    private Client client;

    private String text;

    public Message() {
    }

    public Message(int id) {
        this.id = id;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
