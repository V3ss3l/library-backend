package org.library.tdo.book_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Storages extends PanacheEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Package bookPackage;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Book book;

    @Column(name = "book_count")
    private int countBooks;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Storage storage;
}
