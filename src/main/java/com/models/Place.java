package com.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Menerith on 16-Nov-16.
 */

@Entity
@Table(name="Place")
public class Place {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_place")
    private int idplace;
    @NotNull
    @Column(name = "latitude")
    private double latitude;
    @NotNull
    @Column(name = "longitude")
    private double longitude;
    @NotNull
    @Column(name = "visibility_note")
    private double visibility_note;

    @ManyToOne
    @JoinColumn(name = "id_type_place")
    private typePlace type_place;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Interaction", joinColumns = @JoinColumn(name = "id_place", referencedColumnName = "id_place"),
            inverseJoinColumns = @JoinColumn(name = "id_ad", referencedColumnName = "id_ad"))
    private List<Advertisement> ads;

    public Place() {
    }

    public Place(double latitude, double longitude, typePlace type_place) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.type_place = type_place;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setVisibility_note(double visibility_note) {
        this.visibility_note = visibility_note;
    }

    public void setType_place(typePlace type_place) {
        this.type_place = type_place;
    }

    public void setAds(List<Advertisement> ads) {
        this.ads = ads;
    }

    public double getVisibility_note() {
        return visibility_note;
    }

    public typePlace getType_place() {
        return type_place;
    }

    @JsonBackReference
    public List<Advertisement> getAds() {
        return ads;
    }
}
