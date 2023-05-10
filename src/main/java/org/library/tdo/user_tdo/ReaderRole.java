package org.library.tdo.user_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ReaderRole extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "role_seq",
            sequenceName = "role_sequence",
            initialValue = 1, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    private Long id;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private ReaderJob readerJob;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    private String department;
}
