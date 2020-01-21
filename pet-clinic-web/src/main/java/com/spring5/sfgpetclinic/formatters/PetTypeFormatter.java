package com.spring5.sfgpetclinic.formatters;

import com.spring5.sfgpetclinic.model.PetType;
import com.spring5.sfgpetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Set;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }


    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Set<PetType> findPetTypes = this.petTypeService.findAll();
//        for (PetType type : findPetTypes) {
////            if (type.getName().equals(text)) {
////                return type;
////            }
////        }
//        persons.stream()                        // Convert to steam
//                .filter(x -> "jack".equals(x.getName()))        // we want "jack" only
//                .findAny()                                      // If 'findAny' then return found
//                .orElse(null);
        return findPetTypes.stream()
                .filter(petType -> petType.getName().equals(text))
                .findFirst().orElse(null);
//        throw new ParseException("type not found: " + text, 0);
    }

}
