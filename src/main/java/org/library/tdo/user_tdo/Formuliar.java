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
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Formuliar extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "formuliar_seq",
            sequenceName = "common_sequence",
            initialValue = 1, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "formuliar_seq")
    private Long id;

    @Column(name="date_of_creation")
    @Temporal(TemporalType.DATE)
    private Date dateOfCreation = Date.from(LocalDate.now().atStartOfDay()
            .atZone(ZoneId.systemDefault())
            .toInstant());

    @Column(name = "count_overdue_books", nullable = false)
    @ColumnDefault("0")
    private int countOverdueBooks;

    @OneToOne()
    @JoinColumn (name = "reader_id")
    private Reader reader;

    public static Formuliar findReaderByLoginInfo(String email, String password){
        return Formuliar.find("reader.email = ?1 AND reader.password = ?2",
                email, password).firstResult();
    }
}
