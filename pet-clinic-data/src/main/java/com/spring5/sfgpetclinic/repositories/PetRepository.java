package com.spring5.sfgpetclinic.repositories;

import com.spring5.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PetRepository extends CrudRepository<Pet,Long> {
}
