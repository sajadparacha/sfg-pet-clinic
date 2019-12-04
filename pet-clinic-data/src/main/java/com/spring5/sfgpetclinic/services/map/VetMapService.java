package com.spring5.sfgpetclinic.services.map;

import com.spring5.sfgpetclinic.model.Speciality;
import com.spring5.sfgpetclinic.model.Vet;
import com.spring5.sfgpetclinic.services.SpecialtyService;
import com.spring5.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
/**
 * If no profile is defined spring will have a default profile , otherwise the profiles defined will be taken.
 * In this case since we have not defined a profile yet default will be used by Spring hence this class will be loaded
 */
@Profile({"default","map"})
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
