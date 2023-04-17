package org.library.tdo.hall_tdo;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class HallType extends PanacheEntity {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hall_type_id")
    private int hallTypeID;*/

    @Column(name = "type_name", nullable = false)
    private String typeName;
}
