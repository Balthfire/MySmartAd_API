package com.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Menerith on 16-Nov-16.
 */
@Entity
@Table(name="Type_place")
public class typePlace {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_type_place")
    private int id_type_place;
    @NotNull
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(mappedBy = "type_place", cascade = CascadeType.ALL)
    private List<Place> Places;

    public typePlace() {
    }

    public typePlace(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @JsonBackReference
    public List<Place> getPlaces() {
        return Places;
    }

    public void setPlaces(List<Place> places) {
        Places = places;
    }
}
