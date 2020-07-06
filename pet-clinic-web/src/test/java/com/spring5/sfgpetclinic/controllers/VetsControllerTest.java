package com.spring5.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
class VetsControllerTest {
    MockMvc mockMvc;
    @Mock
    Model model;
    @BeforeEach
    void setUp() {
        //**Build MOck Controller
        mockMvc= MockMvcBuilders.standaloneSetup(VetsController.class).build();
    }

//    @Test
//    void getVetsAsJSON() throws Exception {
//        mockMvc.perform(get("/vets/api/vets")).andExpect(status()
////                .is(200));
//                .isOk());
//        ;
//    }
}