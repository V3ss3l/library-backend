package org.library.tdo.hall_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class LibraryHall extends PanacheEntity {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hall_id")
    private UUID hallId;*/

    @Column(name = "hall_name", nullable = false)
    private String hallName;

    @ManyToOne()
    @JoinColumn(name = "housing_id", nullable = false)
    private Housing housing;

    @ManyToOne()
    @JoinColumn(name = "hall_type_id")
    private HallType hallType;

    @ManyToOne()
    @JoinColumn(name = "admin_id", nullable = false)
    private LibraryAdmin admin;
}
