package org.library.tdo.hall_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;


import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class LibraryAdmin extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private UUID adminID;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surName;

}
