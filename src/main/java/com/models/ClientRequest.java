package com.models;

/**
 * Created by Menerith on 17/11/2016.
 */
public class ClientRequest {


    private int idclient;
    private String name;
    private String address;
    private String city;
    private int zipcode;
    private String telephone;
    private String website;

    public ClientRequest(String name, String address, String city, int zipcode, String telephone, String website) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.telephone = telephone;
        this.website = website;
    }

    public ClientRequest() {
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getWebsite() {
        return website;
    }
}
