package com.spring5.sfgpetclinic.bootstrap;

import com.spring5.sfgpetclinic.model.*;
import com.spring5.sfgpetclinic.services.OwnerService;
import com.spring5.sfgpetclinic.services.PetTypeService;
import com.spring5.sfgpetclinic.services.SpecialtyService;
import com.spring5.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;
    private PetTypeService petTypeService;
    private SpecialtyService specialtyService;

    public DataLoader( OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().size()==0) {
            loadData();
        }


    }

    private void loadData() {
        PetType petType1 = new PetType();
        petType1.setName("Pet1");
        petTypeService.save(petType1);
        PetType petType2 = new PetType();
        petType2.setName("Pet2");
        petTypeService.save(petType2);
        System.out.println("Loaded Pet Types");

        //**Create Specialaties
        Speciality speciality1=new Speciality();
        speciality1.setDescription("radiology");
        specialtyService.save(speciality1);
        Speciality speciality2=new Speciality();
        speciality2.setDescription("surgery");
        specialtyService.save(speciality2);
        Speciality speciality3=new Speciality();
        speciality3.setDescription("dentistry");
        specialtyService.save(speciality3);
        System.out.println("Loaded Specialities");
        //**First Owner
        Owner owner= new Owner();
        owner.setId(1L);
        owner.setFirstName("Sajjad");
        owner.setLastName("Paracha");
        owner.setAddress("Khobar Address");
        owner.setCity("Khobar City");
        owner.setTelephone("08309280321");
        Pet pet1=new Pet();
        pet1.setPetType(petType1);
        pet1.setOwner(owner);
        pet1.setBirthday(LocalDate.now());
        pet1.setName("Pet 1");
        owner.getPets().add(pet1);
        ownerService.save(owner);

        //**Second Owner
        Owner owner2= new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Waqar");
        owner2.setLastName("Paracha");
        owner2.setAddress("Quetta Address");
        owner2.setCity("Quetta Address");
        owner2.setTelephone("798739217321");
        Pet pet2=new Pet();
        pet2.setPetType(petType2);
        pet2.setOwner(owner2);
        pet2.setBirthday(LocalDate.now());
        pet2.setName("Pet 2");
        owner2.getPets().add(pet2);
        ownerService.save(owner2);

        System.out.println("Loaded Owners");
        //*First Vet
        Vet vet=new Vet();
        vet.setId(1L);
        vet.setFirstName("Baqir");
        vet.setLastName("Ali");
        vet.getSpecialities().add(speciality1);
        vetService.save(vet);
        //*Second Vet
        Vet vet2=new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Zafar");
        vet2.setLastName("Luni");
        vet.getSpecialities().add(speciality2);
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
