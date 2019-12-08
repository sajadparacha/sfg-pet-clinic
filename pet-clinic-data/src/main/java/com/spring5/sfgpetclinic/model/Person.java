package com.spring5.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
@Setter
@Getter
@MappedSuperclass
/*
Because of the above annotation no object for this class will be created in the database
 */
public class Person extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    }

