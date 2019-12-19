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
//@Builder
/*Lombok Annotations*/


@Entity
@Table(name = "owner")
public class Owner extends Person{
    /**
     * Had to annotate the constructor with @Builder but normally we annotate class with @Builder
     * This is because this object is having multiple enharitance and id was not being picked in the generated builder
     * when we were annotating the class with @Builder , however annotating the constructor resolved the problem
     * @param id
     * @param firstName
     * @param lastName
     * @param pets
     * @param address
     * @param city
     * @param telephone
     */
    @Builder
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
