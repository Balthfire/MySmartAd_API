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

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Interaction", joinColumns = @JoinColumn(name = "id_ad", referencedColumnName = "id_ad"),
            inverseJoinColumns = @JoinColumn(name = "id_place", referencedColumnName = "id_place"))
    private List<Place> places;
}
