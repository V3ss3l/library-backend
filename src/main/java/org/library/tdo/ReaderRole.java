package org.library.tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ReaderRole extends PanacheEntity {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int readerRoleID;*/

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private ReaderJob readerJob;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    private String department;
}
