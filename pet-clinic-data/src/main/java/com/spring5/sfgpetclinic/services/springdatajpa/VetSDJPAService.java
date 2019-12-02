package com.spring5.sfgpetclinic.services.springdatajpa;

import com.spring5.sfgpetclinic.model.Vet;
import com.spring5.sfgpetclinic.repositories.VetRepository;
import com.spring5.sfgpetclinic.services.VetService;

import java.util.HashSet;
import java.util.Set;

//import com.spring5.sfgpetclinic.repositories.SpecialityRepository;

//import com.spring5.sfgpetclinic.services.SpecialtyService;

public class VetSDJPAService implements VetService {
    VetRepository vetRepository;
//    SpecialityRepository specialityRepository;

    public VetSDJPAService(VetRepository vetRepository//, SpecialityRepository specialityRepository
    ) {
        this.vetRepository = vetRepository;
        //this.specialityRepository = specialityRepository;
    }

    @Override
    public Vet findById(Long aLong) {
        /*
        * If there is a novet with this id retunr null otherwise the object
        * */

        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets=new HashSet<>();
        /*
        * findAll returns an iteratable object , forEach will iterate though it and add each element to vets set
        * Normally this is achieved by
        * A loop for iteration
        *   inside the loop fetch an element from itretable collection and add it to set
        * Below is the short form of doing it
        * */
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
