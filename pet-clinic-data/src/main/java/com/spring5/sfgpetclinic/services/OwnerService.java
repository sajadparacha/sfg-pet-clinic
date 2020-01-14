package com.spring5.sfgpetclinic.services;

import com.spring5.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long>{


    Owner findByFirstName(String firstName);
    List<Owner> findAllByFirstName(String firstName);

}
