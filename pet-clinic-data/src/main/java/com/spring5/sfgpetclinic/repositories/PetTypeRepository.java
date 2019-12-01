package com.spring5.sfgpetclinic.repositories;

import com.spring5.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
