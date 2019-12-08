package com.spring5.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/*Lombok Annotations*/
@Setter
@Getter

@NoArgsConstructor
@AllArgsConstructor
@Builder
/*Lombok Annotations*/

@Entity
@Table(name = "speciality")
public class Speciality extends BaseEntity {
    @Column(name = "description")
    private String description;
//    @ManyToMany(mappedBy = "specialities")
//    private Set<Vet> vetSet=new HashSet<>();

  }
