package com.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Menerith on 16-Nov-16.
 */
@Entity
@Table(name="User")
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private int iduser;
    @NotNull
    @Column(name = "pseudo")
    private String pseudo;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "lastname")
    private String lastname;
    @NotNull
    @Column(name = "address")
    private String address;
    @NotNull
    @Column(name = "email")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "UserAndClient", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id_client  "))
    private List<Client> clients;

    @ManyToOne
    @JoinColumn(name = "id_type_user")
    private Type_User type_user;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Commentary> commentaries;


}
