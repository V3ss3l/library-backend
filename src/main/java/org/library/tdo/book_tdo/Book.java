package org.library.tdo.book_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import org.library.tdo.Adress;

import javax.persistence.*;
import java.util.List;
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

    public static List<Book> findByName(String name){
        return find("bookName = ?1", name).list();
    }
    public static List<Book> findByAuthor(String author){
        return find("author = ?1", author).list();
    }
    public static List<Book> findByPublisher(String publisherName){
        return find("pubisher = ?1", publisherName).firstResult();
    }
}
