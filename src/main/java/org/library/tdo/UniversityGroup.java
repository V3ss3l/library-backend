package org.library.tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Data
@Entity
public class UniversityGroup extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="group_id")
    private UUID groupID;
    @Column(name ="group_name")
    private String name;
    @Column(name = "start_date")
    private Date startDate;
}
