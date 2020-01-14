package com.spring5.sfgpetclinic.controllers;

import com.spring5.sfgpetclinic.model.Owner;
import com.spring5.sfgpetclinic.services.springdatajpa.OwnerSDJPAService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    private OwnerSDJPAService ownerService;
    @InjectMocks
    /*
    This will initialize the spring controller and inject mock objects to it
     */
    OwnerController ownerController;
    @Mock
    Model model;
    MockMvc mockMvc;
    Set<Owner> owners;
    @BeforeEach
    void setUp() {
        owners=new HashSet<Owner>();
        owners.add(Owner.builder().id(1L).build());
//        owners.add(Owner.builder().id(14L).build());
        owners.add(Owner.builder().id(3L).address("Khobar").build());
        //**Build MOck Controller
        mockMvc= MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void showListOfOwners() throws Exception {
        //Given
            //The Hashset is already created in setup method
        //When
        //**Setup mock interection
        when(ownerService.findAll()).thenReturn(owners);
        //Then

        mockMvc.perform(get("/owners/index")).andExpect(status()
//                .is(200));
                .isOk()).
                andExpect(view().name("/owner/index"))
                .andExpect(model().attribute("owners",hasSize(2)))
        ;

    }
    @Test
    void showListOfOwners1() throws Exception {
        //Given
//        The Hashset is already created in setup method
        //When
        //**Setup mock interection
        when(ownerService.findAll()).thenReturn(owners);
        //Then

        mockMvc.perform(get("/owners/ownerList")).andExpect(status()
//                .is(200));
                .isOk()).
                andExpect(view().name("/owner/index"))
                .andExpect(model().attribute("owners",hasSize(2)))
        ;

    }
    @Test
    void find() throws Exception {
       mockMvc.perform(get("/owners/find"))
               .andExpect(status().isOk())
               .andExpect(view().name("owner/findOwners"));
       //optional , check there should be no interactiobs with owner service during this test
        verifyNoInteractions(ownerService);
    }

    @Test
    void showOwner() throws Exception {
        //Given
        Owner owner=Owner.builder().id(123L).build();
        when(ownerService.findById(anyLong())).thenReturn(owner);
        //When
        mockMvc.perform(get("/owners/123"))
                //Then
                .andExpect(status().isOk())
                .andExpect(view().name("/owner/ownerDetails"))
                .andExpect(model().attributeExists("owner"));

    }

    @Test
    void initFindForm() throws Exception {
        //Given
        Owner owner=Owner.builder().id(1L).build();

//        when(ownerService.findAllByFirstName(any())).thenReturn(owner);
        //When
        mockMvc.perform(get("/owners/find"))
                //Then
                .andExpect(status().isOk())
                .andExpect(view().name("owner/findOwners"))
                .andExpect(model().attributeExists("owner"));


    }
    @Test
    void processFindOwnerReturnMany() throws Exception {
        //Given
        Owner owner=Owner.builder().id(1L).build();
        Owner owner1=Owner.builder().id(2L).build();
        List<Owner> ownerArrayList=new ArrayList<>();
        ownerArrayList.add(owner);
        ownerArrayList.add(owner1);
        when(ownerService.findAllByFirstName(any())).thenReturn(ownerArrayList);
        //When
        mockMvc.perform(get("/owners/findOwners"))
                //Then
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))

                .andExpect(model().attribute("owners",hasSize(2)));
        //verify(ownerService.findAllByFirstName(anyString()));

    }
    @Test
    void processFindOwnerOne() throws Exception {
        //Given
        Owner owner=Owner.builder().id(1L).build();

        List<Owner> ownerArrayList=new ArrayList<>();
        ownerArrayList.add(owner);

        when(ownerService.findAllByFirstName(any())).thenReturn(ownerArrayList);
        //When
        mockMvc.perform(get("/owners/findOwners"))
                //Then
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1"))

                .andExpect(model().attribute("owners",hasSize(1)));
//        verify(ownerService.findAllByFirstName(anyString()));
    }
}