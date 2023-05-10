package org.library.tdo.hall_tdo;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class HallType extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "hall_type_seq",
            sequenceName = "hall_type_sequence",
            initialValue = 1, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hall_type_seq")
    private Long id;

    @Column(name = "type_name", nullable = false)
    private String typeName;
}
