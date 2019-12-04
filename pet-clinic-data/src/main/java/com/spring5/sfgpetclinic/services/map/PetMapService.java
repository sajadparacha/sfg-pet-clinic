package com.spring5.sfgpetclinic.services.map;

import com.spring5.sfgpetclinic.model.Pet;
import com.spring5.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
/**
 * If no profile is defined spring will have a default profile , otherwise the profiles defined will be taken.
 * In this case since we have not defined a profile yet default will be used by Spring hence this class will be loaded
 */
@Profile({"default","map"})
public class PetMapService extends AbstractMapService<Pet,Long> implements PetService {
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
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
