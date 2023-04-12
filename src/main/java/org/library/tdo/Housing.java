package org.library.tdo;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Housing extends PanacheEntity {

   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "housing_id")
    private int housingID;*/

    @Column(name = "housing_name", nullable = false)
    private String housingName;

    @ManyToOne()
    @JoinColumn(name = "adress_id", nullable = false)
    private Adress adress;
}
