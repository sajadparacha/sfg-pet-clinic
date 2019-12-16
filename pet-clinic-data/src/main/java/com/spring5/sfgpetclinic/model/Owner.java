package com.spring5.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/*Lombok Annotations*/
@Setter
@Getter
@EqualsAndHashCode(exclude = {"pets"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*Lombok Annotations*/


@Entity
@Table(name = "owner")
public class Owner extends Person{

    public Owner(Long id, String firstName, String lastName, Set<Pet> pets, String address, String city, String telephone) {
        super(id, firstName, lastName);
        this.pets = pets;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private Set<Pet> pets= new HashSet<Pet>();
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;

  }
