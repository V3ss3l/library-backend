package org.library.tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Adress extends PanacheEntity {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "adress_id")
    private UUID adressID;*/


    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String building;

    private String room;

    private String floor;

    public static Adress findByStreet(String street){
        return find("street = ?1", street).firstResult();
    }
}
