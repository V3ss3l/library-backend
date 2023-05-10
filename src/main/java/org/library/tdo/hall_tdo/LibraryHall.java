package org.library.tdo.hall_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class LibraryHall extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "hall_seq",
            sequenceName = "hall_sequence",
            initialValue = 1, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hall_seq")
    private Long id;

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
