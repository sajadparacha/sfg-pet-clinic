package com.spring5.sfgpetclinic.services.map;

import com.spring5.sfgpetclinic.model.PetType;
import com.spring5.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
/**
 * If no profile is defined spring will have a default profile , otherwise the profiles defined will be taken.
 * In this case since we have not defined a profile yet default will be used by Spring hence this class will be loaded
 */
@Profile({"default","map"})
public class PetTypeMapService extends AbstractMapService<PetType,Long> implements PetTypeService {

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType t) {
        return super.save(t);
    }

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }
}
