package org.library.tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Reader extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reader_id")
    private UUID readerID;

    @Column(name = "outer_id")
    private UUID outerID;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surName;

    @ManyToOne()
    @JoinColumn(name = "adress_id", nullable = false)
    private Adress adress;

    @Column(name = "registration_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String cellular;

    @Column(nullable = false)
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
