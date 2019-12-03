package com.spring5.sfgpetclinic.services;

import com.spring5.sfgpetclinic.model.Vet;
import com.spring5.sfgpetclinic.model.Visit;

/**
 * @Author Sajjad Paracha
 */

public interface VetService extends CrudService<Vet,Long>{

    interface ViisitService extends CrudService<Visit,Long> {
    }
}
