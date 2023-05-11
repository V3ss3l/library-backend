package org.library.tdo.book_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Package extends PanacheEntity {
    @Column(name = "count_of_books", nullable = false)
    private int countOfBooks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Book book;

    /*@OneToMany(mappedBy = "bookPackage")
    private List<BookItem> items;

    public void createItems(){
        items = new ArrayList<>(this.countOfBooks);
        for (BookItem book: items) {
            book = new BookItem();
        }
    }*/
}
