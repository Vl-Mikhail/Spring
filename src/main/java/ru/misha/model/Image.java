package ru.misha.model;

import org.codehaus.jackson.annotate.JsonBackReference;

public class Image {

    private int id;
    private byte[] image;
    private String url;

    @JsonBackReference
    private Client client;

    public Image() {
    }

    public Image(int id, byte[] image, String url, Client client) {
        this.id = id;
        this.image = image;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

