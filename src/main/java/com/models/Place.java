package com.models;

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
    private double note;
    @NotNull
    @Column(name = "longitude")
    private double longitude;
    @NotNull
    @Column(name = "visibility_note")
    private double visibility_note;

    @ManyToOne
    @JoinColumn(name = "id_type_place")
    private Type_Place type_place;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Interaction", joinColumns = @JoinColumn(name = "id_place", referencedColumnName = "id_place"),
            inverseJoinColumns = @JoinColumn(name = "id_ad", referencedColumnName = "id_ad"))
    private List<Advertisement> ads;

    public Place() {
    }

    public Place(double note, double longitude, Type_Place type_place) {
        this.note = note;
        this.longitude = longitude;
        this.type_place = type_place;
    }

    public double getNote() {
        return note;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getVisibility_note() {
        return visibility_note;
    }

    public Type_Place getType_place() {
        return type_place;
    }

    public List<Advertisement> getAds() {
        return ads;
    }
}
