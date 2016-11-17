package com.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by Menerith on 17/11/2016.
 */
public class AdvertisementRequest {

    private int idad;
    private String name;
    private double height;
    private double length;
    private double price;
    private int idClient;

    public AdvertisementRequest(String name, double height, double length, double price, int idClient) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.price = price;
        this.idClient = idClient;
    }

    public AdvertisementRequest() {
    }

    public int getIdClient() {
        return idClient;
    }

    public String getName() {
        return name;
    }



    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getPrice() {
        return price;
    }
}
