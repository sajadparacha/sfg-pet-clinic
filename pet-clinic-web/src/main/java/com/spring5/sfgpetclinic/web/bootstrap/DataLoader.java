package com.spring5.sfgpetclinic.web.bootstrap;

import com.spring5.sfgpetclinic.model.Owner;
import com.spring5.sfgpetclinic.model.Vet;
import com.spring5.sfgpetclinic.services.OwnerService;
import com.spring5.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
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
