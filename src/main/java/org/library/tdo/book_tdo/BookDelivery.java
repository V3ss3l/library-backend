package org.library.tdo.book_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Data;
import org.library.tdo.user_tdo.Formuliar;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class BookDelivery extends PanacheEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Formuliar formuliar;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @Column(name = "get_date")
    @Temporal(TemporalType.DATE)
    private Date dateOfGet = Date.from(LocalDate.now().atStartOfDay()
            .atZone(ZoneId.systemDefault())
            .toInstant());

    @Column(name = "expire_date")
    @Temporal(TemporalType.DATE)
    private Date dateOfExpire = new Date(dateOfGet.getTime() + 0x337f9800);

    public static List<BookDelivery> getListOfOrders(Long formuliarId){
        return find("formuliar.id = ?1", formuliarId).list();
    }
}
