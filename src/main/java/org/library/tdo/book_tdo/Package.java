package org.library.tdo.book_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Package extends PanacheEntity {
    @Column(name = "count_of_books", nullable = false)
    private int countOfBooks;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Book book;
}
