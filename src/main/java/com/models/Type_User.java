package com.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Menerith on 16-Nov-16.
 */
@Entity
@Table(name="Type_User")
public class Type_User {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_type_user")
    private int idtypeuser;
    @NotNull
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(mappedBy = "type_user", cascade = CascadeType.ALL)
    private List<User> Users;
}
