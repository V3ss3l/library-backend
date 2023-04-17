package org.library.tdo.book_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Storage extends PanacheEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String abbreviation;
}
