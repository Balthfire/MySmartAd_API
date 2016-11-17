package com.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Menerith on 16-Nov-16.
 */
@Entity
@Table(name="Advertisement")
public class Advertisement {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ad")
    private int idad;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "image")
    private String image;
    @NotNull
    @Column(name = "height")
    private double height;
    @NotNull
    @Column(name = "length")
    private double length;
    @NotNull
    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Interaction", joinColumns = @JoinColumn(name = "id_ad", referencedColumnName = "id_ad"),
            inverseJoinColumns = @JoinColumn(name = "id_place", referencedColumnName = "id_place"))
    private List<Place> places;

    @OneToMany(mappedBy = "ad", cascade = CascadeType.ALL)
    private List<Commentary> commentaries;

    public Advertisement() {
    }

    public Advertisement(String name,Client client, double height, double length, double price) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.price = price;
        this.client = client;
    }

    public double getHeight() {
        return height;
    }

    public void setHeigth(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<Commentary> getCommentaries() {
        return commentaries;
    }

    public void setCommentaries(List<Commentary> commentaries) {
        this.commentaries = commentaries;
    }
}
