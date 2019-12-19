package com.spring5.sfgpetclinic.services;

import com.spring5.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long>{


    Owner findByFirstName(String firstName);

}
