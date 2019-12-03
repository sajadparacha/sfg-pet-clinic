package com.spring5.sfgpetclinic.services.springdatajpa;

import com.spring5.sfgpetclinic.model.Speciality;
import com.spring5.sfgpetclinic.repositories.SpecialityRepository;
import com.spring5.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
/**
 * Since there is no profile like this enabled in this application , spring boot will consider this as a disabled profile
 * and load other instance of OwenerService for now i.e. OwnerServiceMap
 */
@Profile("SpringDataJPA")
public class VetSpecialitySDJPAService implements SpecialtyService {
    SpecialityRepository specialityRepository;

    public VetSpecialitySDJPAService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities=new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public void delete(Speciality object) {
        specialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialityRepository.deleteById(aLong);
    }
}
