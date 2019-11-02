package com.spring5.sfgpetclinic.services;

import com.spring5.sfgpetclinic.model.Vet;

import java.util.Set;

/**
 * @Author Sajjad Paracha
 */
public interface VetService {

    Vet findById(Long id);
    Vet save(Vet owner);
    Set<Vet> findAll();

}
