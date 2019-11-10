package com.spring5.sfgpetclinic.services.map;

import com.spring5.sfgpetclinic.model.Pet;
import com.spring5.sfgpetclinic.services.PetService;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet,Long> implements PetService {
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(),pet);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
    super.deleteById(id);
    }
}
