package com.models;

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
}
