package org.library.tdo.user_tdo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ReaderJob extends PanacheEntity {

    @Column(name = "job_name", nullable = false)
    private String jobName;
}
