package com.spring5.sfgpetclinic.bootstrap;

import com.spring5.sfgpetclinic.model.Owner;
import com.spring5.sfgpetclinic.model.PetType;
import com.spring5.sfgpetclinic.model.Vet;
import com.spring5.sfgpetclinic.services.OwnerService;
import com.spring5.sfgpetclinic.services.PetTypeService;
import com.spring5.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;
    private PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType petType1 = new PetType();
        petType1.setName("Pet1");
        petTypeService.save(petType1);
        PetType petType2 = new PetType();
        petType2.setName("Pet2");
        petTypeService.save(petType2);
        System.out.println("Loaded Pet Types");
        //**First Owner
        Owner owner= new Owner();
        owner.setId(1L);
        owner.setFirstName("Sajjad");
        owner.setLastName("Paracha");
        ownerService.save(owner);
        //**Second Owner
        Owner owner2= new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Waqar");
        owner2.setLastName("Paracha");
        ownerService.save(owner2);

        System.out.println("Loaded Owners");
        //*First Vet
        Vet vet=new Vet();
        vet.setId(1L);
        vet.setFirstName("Baqir");
        vet.setLastName("Ali");
        vetService.save(vet);
        //*Second Vet
        Vet vet2=new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Zafar");
        vet2.setLastName("Luni");
        vetService.save(vet2);

        System.out.println("Loaded Vets");



    }
}
