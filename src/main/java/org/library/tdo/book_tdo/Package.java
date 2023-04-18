package org.library.tdo.book_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Package extends PanacheEntity {
    @Column(name = "count_of_books", nullable = false)
    private int countOfBooks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Book book;
}
