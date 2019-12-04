package com.spring5.sfgpetclinic.services.map;

import com.spring5.sfgpetclinic.model.Speciality;
import com.spring5.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
/**
 * If no profile is defined spring will have a default profile , otherwise the profiles defined will be taken.
 * In this case since we have not defined a profile yet default will be used by Spring hence this class will be loaded
 */
@Profile({"default","map"})
public class SpecialtyMapService extends AbstractMapService<Speciality,Long> implements SpecialtyService {
    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality t) {
        return super.save(t);
    }

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }
}
