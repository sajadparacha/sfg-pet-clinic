package com.spring5.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
/*Lombok Annotations*/
@Setter
@Getter
@EqualsAndHashCode(exclude = {"pet"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*Lombok Annotations*/
@Entity
@Table(name = "visit")
public class Visit extends BaseEntity {
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "desciption")
    private String desciption;
    @ManyToOne()
    @JoinColumn(name = "pet_id")
    private Pet pet;


}
