package com.spring5.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
/*Lombok Annotations*/
@Setter
@Getter
@EqualsAndHashCode(exclude = {"owner","visitSet"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
/*Lombok Annotations*/
@Entity
@Table(name = "pet")
public class Pet extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id")
    private Set<Visit> visitSet=new HashSet<>();

    @Column(name = "name")
    private String name;


     @Column(name = "birthday")
    private LocalDate birthday;




   }
