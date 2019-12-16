package com.spring5.sfgpetclinic.services.map;

import com.spring5.sfgpetclinic.model.Owner;
import com.spring5.sfgpetclinic.model.Pet;
import com.spring5.sfgpetclinic.services.OwnerService;
import com.spring5.sfgpetclinic.services.PetService;
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
//@Profile("mapService")
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    private PetService petService;
    private PetTypeService petTypeService;


    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
        System.out.println("Constructor callsed fr OwnerServiceMap");
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
            System.out.println("Save Method called from inside OwnerServiceMap");
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

        return this.findAll();

    }
}
