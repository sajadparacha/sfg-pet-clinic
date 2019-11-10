package com.spring5.sfgpetclinic.services;

import com.spring5.sfgpetclinic.model.Owner;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface OwnerService extends CrudService<Owner,Long>{


    Set<Owner> findByFirstName(String firstName);

}
