package com.spring5.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/*Lombok Annotations*/
@Setter
@Getter
@EqualsAndHashCode(exclude = {"specialities"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*Lombok Annotations*/
@Entity
@Table(name = "vet")
public class Vet extends Person {
    @ManyToMany
    @JoinTable(
            name = "vet_speciality",
            joinColumns= @JoinColumn(name = "vet_id"),
            inverseJoinColumns=@JoinColumn(name="speciality_id")
    )
    private Set<Speciality> specialities=new HashSet<>();

    public int getNrOfSpecialties(){
        return specialities!=null?specialities.size():0;
    }
}
