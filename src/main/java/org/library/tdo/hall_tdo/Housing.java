package org.library.tdo.hall_tdo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.library.tdo.Adress;

import javax.persistence.*;

@Data
@Entity
public class Housing extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "housing_seq",
            sequenceName = "housing_sequence",
            initialValue = 1, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "housing_seq")
    private Long id;

    @Column(name = "housing_name", nullable = false)
    private String housingName;

    @ManyToOne()
    @JoinColumn(name = "adress_id", nullable = false)
    private Adress adress;
}
