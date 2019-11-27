package com.spring5.sfgpetclinic.repositories;

import com.spring5.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
