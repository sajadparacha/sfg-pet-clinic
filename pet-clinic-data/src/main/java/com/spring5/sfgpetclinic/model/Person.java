package com.spring5.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
/*
Because of the above annotation no object for this class will be created in the database
 */
public class Person extends BaseEntity {
    public Person(Long id,String firstName,String lastName) {
        super(id);
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    }

