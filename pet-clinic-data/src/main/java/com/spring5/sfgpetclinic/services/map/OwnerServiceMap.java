package com.spring5.sfgpetclinic.services.map;

import com.spring5.sfgpetclinic.model.Owner;
import com.spring5.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Owner> findByFirstName(String firstName) {
        return null;
    }
}
