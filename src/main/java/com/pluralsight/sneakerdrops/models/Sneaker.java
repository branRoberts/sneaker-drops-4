package com.pluralsight.sneakerdrops.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sneaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int releaseYear;

    public Sneaker(String name, double price, int releaseYear) {
        this.name = name;
        this.price = price;
        this.releaseYear = releaseYear;
    }

    public Sneaker() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }

    @Override
    public String toString() {
        return "Sneaker{id=" + id + ", name='" + name + "'}";
    }
}