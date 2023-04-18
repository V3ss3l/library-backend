package org.library.tdo.book_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class Book extends PanacheEntity {

    private String bookName;
    private String author;
    private String ISBN;
    private String BBK;
    private String UDK;
    private int pagesCount;
    private int yearOfPublishing;
    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisher;
    private String language;
    private String annotation;
    private String additionalInfo;
}
