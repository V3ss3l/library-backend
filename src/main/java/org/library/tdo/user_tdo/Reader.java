package org.library.tdo.user_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.library.tdo.Adress;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Reader extends PanacheEntity {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reader_id")
    private UUID readerID;*/

    /*@Column(name = "outer_id")
    private UUID outerID;*/

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surName;

    @ManyToOne()
    @JoinColumn(name = "adress_id")
    private Adress adress;

    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Date registrationDate = Date.from(LocalDate.now().atStartOfDay()
            .atZone(ZoneId.systemDefault())
            .toInstant());

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String cellular;

    @Column(nullable = false, unique = true)
    private String password;

    private int course;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private UniversityGroup group;

    @Column(name = "receipt_date")
    @Temporal(TemporalType.DATE)
    private Date receiptDate;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @ManyToOne()
    @JoinColumn(name = "role_id", nullable = false)
    private ReaderRole role;
}
