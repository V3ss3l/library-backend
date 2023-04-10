package org.library.tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;


@Data
@Entity
public class ReadingHall extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hall_id")
    private UUID hallId;

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
