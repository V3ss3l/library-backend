package org.library.tdo.book_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Storage extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "storage_seq",
            sequenceName = "storage_sequence",
            initialValue = 1, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storage_seq")
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String abbreviation;
}
