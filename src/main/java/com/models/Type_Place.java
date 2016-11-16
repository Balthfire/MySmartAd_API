package com.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Menerith on 16-Nov-16.
 */
@Entity
@Table(name="Type_Place")
public class Type_Place {


    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_place")
    private int idplace;
    @NotNull
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(mappedBy = "type_place", cascade = CascadeType.ALL)
    private List<Place> Places;

}
