package com.spring5.sfgpetclinic.services;

import com.spring5.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long>{


    Set<Owner> findByFirstName(String firstName);

}
