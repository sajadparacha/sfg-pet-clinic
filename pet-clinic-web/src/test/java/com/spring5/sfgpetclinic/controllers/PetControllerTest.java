package com.spring5.sfgpetclinic.controllers;

import com.spring5.sfgpetclinic.model.Owner;
import com.spring5.sfgpetclinic.model.Pet;
import com.spring5.sfgpetclinic.model.PetType;
import com.spring5.sfgpetclinic.services.OwnerService;
import com.spring5.sfgpetclinic.services.PetService;
import com.spring5.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {
    @InjectMocks
    PetController petController;
    @Mock
    PetService petService;
    @Mock
    OwnerService ownerService;
    @Mock
    Model  model;
    MockMvc mockMvc;
    Owner owner;
    Set<PetType> petTypes;
    Pet dog;
    @BeforeEach
    void setUp() {
        //**Creat an owner object
        owner=Owner.builder().id(1L).firstName("Sheraz").build();
        //**Create PetType Set
        PetType petTypeDog=PetType.builder().id(1L).name("Dog").build();
        PetType petTypeCat=PetType.builder().id(2L).name("Cat").build();
        petTypes=new HashSet<>();
        petTypes.add(petTypeDog);
        petTypes.add(petTypeCat);

        dog=Pet.builder().id(1L).name("Tommy").build();

        mockMvc= MockMvcBuilders.standaloneSetup(petController).build();
        when(ownerService.findById(anyLong())).thenReturn(owner);
        when(petTypeService.findAll()).thenReturn(petTypes);

    }

    @Mock
    PetTypeService petTypeService;
    @Test
    void initCreationForm() throws Exception {


        //When
        mockMvc.perform(get("/owners/1/pets/new"))
                //Then
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("pet"))
        ;
        //verify(,times(1)).;

    }

    @Test
    void processCreationForm() throws Exception {


        //When
        mockMvc.perform(post("/owners/1/pets/new"))
                //Then
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
//                .andExpect(model().attributeExists())
                ;
        verify(petService,times(1)).save(any());


    }

    @Test
    void initUpdateForm() throws Exception {
        when(petService.findById(any())).thenReturn(dog);
        //When
        mockMvc.perform(get("/owners/1/pets/1/edit"))
                //Then
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeExists("pet"))
        ;


    }

    @Test
    void processUpdateForm() throws Exception {

        //When
        mockMvc.perform(post("/owners/1/pets/1/edit"))
                //Then
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))
                .andExpect(model().attributeExists("pet"))
        ;
        verify(petService,times(1)).save(any());

    }
}