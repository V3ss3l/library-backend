package org.library.tdo.book_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import org.library.tdo.hall_tdo.LibraryHall;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Storages extends PanacheEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Package bookPackage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Book book;

    /*@OneToMany(mappedBy = "storage")
    private List<BookItem> items = new ArrayList<>();*/

    @Column(name = "book_count")
    private int countBooks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Storage bookStorage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private LibraryHall hall;

    public static List<Storages> getStoragesByAdminID(Long id){
        return Storages.find("hall.admin.id = ?1", id).list();
    }

    public static List<Storages> getStoragesByBook(Long id){
        return Storages.find("book.id = ?1", id).list();
    }

    /*public void addItems(){
        items = new ArrayList<>(this.countBooks);
    }*/
}
