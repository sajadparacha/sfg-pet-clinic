package com.spring5.sfgpetclinic.services.springdatajpa;

import com.spring5.sfgpetclinic.model.Owner;
import com.spring5.sfgpetclinic.repositories.OwnerRepository;
import com.spring5.sfgpetclinic.repositories.PetRepository;
import com.spring5.sfgpetclinic.repositories.PetTypeRepository;
import com.spring5.sfgpetclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Slf4j
@Service
/**
 * Since there is no profile like this enabled in this application , spring boot will consider this as a disabled profile
 * and load other instance of OwenerService for now i.e. OwnerServiceMap
 */
@Profile("SpringDataJPA")
public class OwnerSDJPAService implements OwnerService {
    private  PetRepository petRepository;
    private PetTypeRepository petTypeRepository;
    private OwnerRepository ownerRepository;

    public OwnerSDJPAService(PetRepository petRepository, PetTypeRepository petTypeRepository, OwnerRepository ownerRepository) {
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
//    public Set<Owner> findByFirstName(String firstName) {
//        return ownerRepository.findByFirstName(firstName);
//    }

    public Owner findByFirstName(String firstName) {
        return ownerRepository.findByFirstName(firstName);
    }

    @Override
    public List<Owner> findAllByFirstName(String firstName) {
       return ownerRepository.findAllByFirstNameLike(firstName);
    }

    @Override
    public Owner findById(Long aLong) {
        /**
         * findById will return an optional , orElse will retunr null if there is no object in optional otherwise the object will be returned.
         */
        log.debug("findById is Called from "+this);
         return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {

        System.out.println("#######################################");

        System.out.println("#######################################");

        System.out.println("#######################################");

        System.out.println("#######################################");

        return ownerRepository.save(owner);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners=new HashSet<>();
         ownerRepository.findAll().forEach(owners::add);
         return owners;
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }


}
