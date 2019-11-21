package com.spring5.sfgpetclinic.services.map;

import com.spring5.sfgpetclinic.model.Speciality;
import com.spring5.sfgpetclinic.model.Vet;
import com.spring5.sfgpetclinic.services.SpecialtyService;
import com.spring5.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {
    private SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if(vet.getSpecialities().size()>0){
            vet.getSpecialities().forEach(speciality -> {
                if(speciality.getId()==null){
                    Speciality speciality1= specialtyService.save(speciality);
                    speciality.setId(speciality1.getId());
                }
            });

        }
        return super.save(vet);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
