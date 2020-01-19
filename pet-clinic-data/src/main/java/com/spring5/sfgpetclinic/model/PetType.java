package com.spring5.sfgpetclinic.model;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name = "pet_type")
public class PetType extends BaseEntity{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return name;
    }


    @Builder
    public PetType(Long id,String name) {
        super(id);
        this.name=name;
    }

    public PetType() {
    }
}
