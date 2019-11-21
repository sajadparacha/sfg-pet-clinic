package com.spring5.sfgpetclinic.services.map;

import com.spring5.sfgpetclinic.model.Speciality;
import com.spring5.sfgpetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
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
