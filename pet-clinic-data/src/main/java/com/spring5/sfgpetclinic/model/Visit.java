package com.spring5.sfgpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
