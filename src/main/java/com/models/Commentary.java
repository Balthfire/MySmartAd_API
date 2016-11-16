package com.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Menerith on 16-Nov-16.
 */
@Entity
@Table(name="Commentary")
public class Commentary {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_commentary")
    private int idcommentary;
    @NotNull
    @Column(name = "note")
    private double note;
    @NotNull
    @Column(name = "comment_text")
    private String commenttext;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_ad")
    private User ad;
    @ManyToOne
    @JoinColumn(name = "id_place")
    private Place place;

}
