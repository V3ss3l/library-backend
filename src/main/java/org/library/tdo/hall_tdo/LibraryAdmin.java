package org.library.tdo.hall_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.library.tdo.user_tdo.Formuliar;


import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class LibraryAdmin extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "admin_seq",
            sequenceName = "admin_sequence",
            initialValue = 1, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_seq")
    private Long id;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surName;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    public static LibraryAdmin findAdminByLoginInfo(String login, String password){
        return LibraryAdmin.find("login = ?1 AND password = ?2",
                login, password).firstResult();
    }
}
