package org.library.tdo.user_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Faculty extends PanacheEntity {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "faculty_id")
    private int facultyID;*/

    @Column(name = "faculty_name", nullable = false)
    private String facultyName;
}
