package com.spring5.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{
    private PetType petType;
    private Owner owner;
    private LocalDate birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
