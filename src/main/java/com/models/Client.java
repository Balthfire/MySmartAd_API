package com.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Menerith on 16-Nov-16.
 */
@Entity
@Table(name="Client")
public class Client {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_client")
    private int idclient;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "address")
    private String address;
    @NotNull
    @Column(name = "city")
    private String city;
    @Column(name = "zipcode")
    private int zipcode;
    @NotNull
    @Column(name = "telephone")
    private String telephone;
    @NotNull
    @Column(name = "website")
    private String website;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "UserAndClient", joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id_client"),
            inverseJoinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user"))
    private List<User> users;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Advertisement> ads;

    public Client() {
    }

    public Client(String name, String address, String city, int zipcode, String telephone, String website) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.telephone = telephone;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @JsonBackReference
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @JsonBackReference
    public List<Advertisement> getAds() {
        return ads;
    }


    public void setAds(List<Advertisement> ads) {
        this.ads = ads;
    }
}
