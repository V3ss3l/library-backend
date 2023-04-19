package org.library.tdo.user_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Formuliar extends PanacheEntity {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "formuliar_id")
    private UUID formuliarID;*/

    @Column(name="date_of_creation")
    @Temporal(TemporalType.DATE)
    private Date dateOfCreation = Date.from(LocalDate.now().atStartOfDay()
            .atZone(ZoneId.systemDefault())
            .toInstant());

    @Column(name = "count_overdue_books", nullable = false)
    @ColumnDefault("0")
    private int countOverdueBooks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "reader_id")
    private Reader reader;
}
