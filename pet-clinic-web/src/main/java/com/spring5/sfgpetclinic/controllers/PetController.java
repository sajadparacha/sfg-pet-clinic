package com.spring5.sfgpetclinic.controllers;

import com.spring5.sfgpetclinic.model.Owner;
import com.spring5.sfgpetclinic.model.Pet;
import com.spring5.sfgpetclinic.model.PetType;
import com.spring5.sfgpetclinic.services.OwnerService;
import com.spring5.sfgpetclinic.services.PetService;
import com.spring5.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
    PetService petService;
    OwnerService ownerService;
    PetTypeService petTypeService;
    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }
    /*
    The following attributes will be avaialable in all the controller methods under Model object
     */
    @ModelAttribute("petTypes")
    public Collection<PetType> populatePetTypes() {
        return this.petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
        return this.ownerService.findById(ownerId);
    }


    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

//    @InitBinder("pet")
//    public void initPetBinder(WebDataBinder dataBinder) {
//        dataBinder.setValidator(new PetValidator());
//    }

    @GetMapping("/pets/new")
    public String initCreationForm(Owner owner, Model model) {
        Pet pet = new Pet();
        pet.setOwner(owner);
        owner.getPets().add(pet);
        model.addAttribute("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/new")
    public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
        if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }
        owner.getPets().add(pet);
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        }
        else {
           petService.save(pet);
            return "redirect:/owners/"+owner.getId();
        }
    }

    @GetMapping("/pets/{petId}/edit")
    public String initUpdateForm(@PathVariable("petId") Long petId, Model model) {
        Pet pet = petService.findById(petId);
        model.addAttribute("pet", pet);
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, Model model) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
        }
        else {
            owner.getPets().add(pet);
            petService.save(pet);
            return "redirect:/owners/"+owner.getId();
        }
    }
}
