package com.spring5.sfgpetclinic.repositories;

import com.spring5.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
