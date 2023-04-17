package org.library.tdo.book_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import org.library.tdo.user_tdo.Formuliar;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class BookDelivery extends PanacheEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Formuliar formuliar;

    @Column(name = "book_item_id")
    private Long bookItemId;

    @Column(name = "get_date")
    @Temporal(TemporalType.DATE)
    private Date dateOfGet;

    @Column(name = "expire_date")
    @Temporal(TemporalType.DATE)
    private Date dateOfExpire;
}
