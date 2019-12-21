package com.spring5.sfgpetclinic.services.map;

import com.spring5.sfgpetclinic.model.Owner;
import com.spring5.sfgpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerServiceMapTest {
    /*
    We dont need to use Makito here because it's a simple Map based service and we can intaract with it like POJO
     */
     private OwnerService ownerService;
     Owner owner;
     Long ownerId=1L;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        //**We can directly initialize these services as they are normal java objects

        //Here we are injecting the dependencies ourselves which spring does for teh actuall service out of the box
        ownerService=new OwnerServiceMap(new PetMapService(),new PetTypeMapService());

        owner=new Owner();
        owner.setId(ownerId);
        owner.setFirstName("Sajjad");
        ownerService.save(owner);
    }

    @Test
    void findById() {
       //Given
        Owner owner=ownerService.findById(1L);

        // When
        assertEquals(ownerId,owner.getId());
        // Then
        System.out.println("Test Has Been Passwed and owner was successfully searched by using owner id");

//        ownerService
    }

    @Test
    void save() {
        //Given
        Owner owner1=new Owner();
        owner1.setId(2L);

        // When
        ownerService.save(owner1);
        // Then
        assertEquals(2L,ownerService.findById(2L).getId());
    }

    @Test
    void findAll() {
        //Given
        Set<Owner> ownerSet=new HashSet<Owner>();
        //When
        ownerSet=ownerService.findAll();
        //Then
        assertEquals(1,ownerSet.size());
    }

    @Test
    void delete() {
        //Given
        Owner owner=ownerService.findById(1L);
        //When
        ownerService.delete(owner);
        //Then
        assertEquals(0,ownerService.findAll().size());
    }

    @Test
    void deleteById() {
        //Given
        Long ownerId=1L;
        //When
        ownerService.deleteById(ownerId);
        //Then
        assertEquals(0,ownerService.findAll().size());

    }

    @Test
    void findByFirstName() {
        //Given
        String ownerName="Sajjad";
        //When
//        Set<Owner> owners=ownerService.findByFirstName(ownerName);
//        Owner owner2=owners.stream()
//                .filter(owner -> owner.getFirstName().equalsIgnoreCase(ownerName))
//                .findFirst()
//                .orElse(null);
        Owner owner2=ownerService.findByFirstName(ownerName);

        //Then
        assertEquals(ownerName,owner2.getFirstName());
    }
}