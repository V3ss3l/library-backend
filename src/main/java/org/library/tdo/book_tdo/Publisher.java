package org.library.tdo.book_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Entity;
@Data
@Entity
public class Publisher extends PanacheEntity {
    private String name;
    private String city;
}
