package com.spring5.sfgpetclinic.services.map;

import com.spring5.sfgpetclinic.model.Owner;
import com.spring5.sfgpetclinic.model.Pet;
import com.spring5.sfgpetclinic.services.OwnerService;
import com.spring5.sfgpetclinic.services.PetService;
import com.spring5.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    private PetService petService;
    private PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if(owner!=null) {
            if(owner.getPets()!=null){
                owner.getPets().forEach(pet ->{
                    if(pet.getPetType()!=null){
                        //**If the id of pet type is null that means it is new object and we need to save it
                        if(pet.getPetType().getId()==null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type Is Required");
                    }
                    //**If id of the pet object is null it means it is a new object and we need to save it
                    if(pet.getId()==null){
                        Pet savedPet=petService.save(pet);
                        pet.setId(savedPet.getId());

                    }
                });
            }
            return super.save(owner);
        }
        else {
            return null;
        }
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
