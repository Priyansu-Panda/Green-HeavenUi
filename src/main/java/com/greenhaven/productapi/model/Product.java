package com.greenhaven.productapi.model;

//import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue()

    private  Long id;
    private String title;
    private String description;
    private double price;
    private String image;

//  Getter And setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
