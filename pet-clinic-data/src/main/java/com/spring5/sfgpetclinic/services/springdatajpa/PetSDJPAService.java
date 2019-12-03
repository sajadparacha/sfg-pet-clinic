package com.spring5.sfgpetclinic.services.springdatajpa;

import com.spring5.sfgpetclinic.model.Pet;
import com.spring5.sfgpetclinic.repositories.PetRepository;
import com.spring5.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
/**
 * Since there is no profile like this enabled in this application , spring boot will consider this as a disabled profile
 * and load other instance of OwenerService for now i.e. OwnerServiceMap
 */
@Profile("SpringDataJPA")
@Service
public class PetSDJPAService implements PetService {
    PetRepository petRepository;

    public PetSDJPAService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets=new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return null;
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
