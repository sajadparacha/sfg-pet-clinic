package com.spring5.sfgpetclinic.services.springdatajpa;

import com.spring5.sfgpetclinic.model.Owner;
import com.spring5.sfgpetclinic.repositories.OwnerRepository;
import com.spring5.sfgpetclinic.repositories.PetRepository;
import com.spring5.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
/*If you don't annotate the test class with thsi annotation you will end up gettting NUllPointerException
    As Mokito will not be able to create mocks for below when statement
    when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
 */
@ExtendWith(MockitoExtension.class)
class OwnerSDJPAServiceTest {
    public static final String FIRST_NAME = "Sajjad";
    @Mock
    private PetRepository petRepository;
    @Mock
    private PetTypeRepository petTypeRepository;
    @Mock
    private OwnerRepository ownerRepository;
    /**
     * Read below post to understand the difference between @Mock and @Inject Mock
     * https://howtodoinjava.com/mockito/mockito-mock-injectmocks/
     *
     * @Mock creates mock objects
     * A mock object is an interface to hide a dependency with cannot be tested
     * in test environment e.g. database, network locations etc.A method invoked
     * using mocked reference does not execute method body defined in class file,
     * rather the method behavior is configured using when-thenReturn methods combinations.
     * Use @Mock to create mocks which are needed to support testing of class to be tested.
     * @InjectMock creates an actual instance of the class
     * In a junit test, we create objects for the class which needs to be
     * tested and it’s methods to be invoked.
     * Use @InjectMocks to create class instances which needs to be tested in test class.
     * Use @InjectMocks when actual method body needs to be executed for a given class.
     * Use @InjectMocks when we need all internal dependencies initialized with mock
     * objects to work method correctly.
     */
    @InjectMocks
    OwnerSDJPAService ownerSDJPAService;
    Owner returnedOwner;
    Long ownerId=1L;
    @BeforeEach
    void setUp() {
        //**Create a new owner object and set id and owner name
        returnedOwner =new Owner();
        returnedOwner.setId(ownerId);
        returnedOwner.setFirstName(FIRST_NAME);
    }

    @Test
    void findByFirstName() {
        //**Given
            //**An owner object is already prepared in setup method
        //When
        //**Setup mock for the method call
        when(ownerRepository.findByFirstName(any())).thenReturn(returnedOwner);
        //**Call the related service method
        Owner sajjad=ownerSDJPAService.findByFirstName(FIRST_NAME);
        //Then
        assertEquals(FIRST_NAME,sajjad.getFirstName());
       verify(ownerRepository).findByFirstName(FIRST_NAME);
    }

    @Test
    void findById() {
        //Given

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
        //When
        Owner owner = ownerSDJPAService.findById(ownerId);
        //Then
        assertNotNull(owner);
    }

    @Test
    void save() {

         //Given
        //**Create a new owner object and set id and owner name
        Owner ownerToSave =new Owner();
        ownerToSave.setId(2L);
        ownerToSave.setFirstName("Waqar");
        //When
        when(ownerRepository.save(any())).thenReturn(returnedOwner);
        Owner owner1=ownerSDJPAService.save(ownerToSave);
        //Then
        assertNotNull(owner1);
        assertEquals(FIRST_NAME,owner1.getFirstName());
    }


    @Test
    void findAll() {
        //Given
        Set<Owner> ownerSet= new HashSet<Owner>();
        ownerSet.add(returnedOwner);
        //When
        when(ownerRepository.findAll()).thenReturn(ownerSet);
        Set<Owner> owners=ownerSDJPAService.findAll();
        //Then
        assertNotNull(owners);
        assertEquals(1,owners.size());
    }

    @Test
    void delete() {
        //Given
        //**We already have an Owner object to delete
        //When
        ownerSDJPAService.delete(returnedOwner);
        //Then
        //**Verify that the delete method of ownerRepository has been executed 1 time
        /*
        Pleaase note we can't use ownerSDJPAService here in verify because only a mock type object is passed to verify
         */
        verify(ownerRepository,times(1)).delete(returnedOwner);
    }

    @Test
    void deleteById() {
        //Given
        //**We already have an Owner object to delete
        //When
        ownerSDJPAService.deleteById(ownerId);
        //Then
        //**Verify that the deleteByID method was only called once , for testing try changing the number below and run the method which should than fail
        verify(ownerRepository,times(1)).deleteById(ownerId);

    }
}