package com.spring5.sfgpetclinic.services;

import com.spring5.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;

@Service
public interface PetService  extends CrudService<Pet,Long>{


}
