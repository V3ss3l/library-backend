package org.library.tdo.book_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BookItem extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "item_seq",
            sequenceName = "item_sequence",
            initialValue = 1, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    private Storages storage;

    @ManyToOne(fetch = FetchType.LAZY)
    private Package bookPackage;
}
