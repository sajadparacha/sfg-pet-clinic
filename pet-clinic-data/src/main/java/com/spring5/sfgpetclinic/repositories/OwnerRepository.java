package com.spring5.sfgpetclinic.repositories;

import com.spring5.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OwnerRepository extends CrudRepository<Owner,Long> {
    public Owner findByLastName(String lastName);
//    public Set<Owner> findByFirstName(String firstName);
public Owner findByFirstName(String firstName);
    public List<Owner> findAllByFirstNameLike(String firstName);
}
