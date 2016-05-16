package ru.misha.model;

import org.codehaus.jackson.annotate.JsonBackReference;

public class Image {

    private int id;
    private byte[] image;

    @JsonBackReference
    private Client client;

    public Image() {
    }

    public Image(int id, byte[] image, Client client) {
        this.id = id;
        this.image = image;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

