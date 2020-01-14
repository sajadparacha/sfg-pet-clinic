package com.spring5.sfgpetclinic.controllers;

import com.spring5.sfgpetclinic.model.Owner;
import com.spring5.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Map;

@RequestMapping("owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping({"","/","/index","ownerList","showOwners"})
    public String showListOfOwners(Model model){

        model.addAttribute("owners",this.ownerService.findAll());

        return "/owner/index";
    }
//    @RequestMapping("/find")
//    public String find(){
//        return "notimplemented";
//    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    /**
     * Custom handler for displaying an owner.
     * @param ownerId the ID of the owner to display
     * @return a ModelMap with the model attributes for the view
     */
    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") int ownerId) {
        ModelAndView mav = new ModelAndView("/owner/ownerDetails");
        Owner owner = ownerService.findById(new Long(ownerId));
        //this.owners.findById(ownerId);
//        for (Pet pet : owner.getPets()) {
//            pet.setVisitsInternal(visits.findByPetId(pet.getId()));
//        }
        mav.addObject(owner);
        return mav;
    }

    @GetMapping("/find")
    public String initFindForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owner/findOwners";
    }

    @GetMapping("/findOwners")
    public String processFindForm(Owner owner, BindingResult result, Map<String, Object> model) {

        // allow parameterless GET request for /owners to return all records
        if (owner.getFirstName() == null) {
            owner.setFirstName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        Collection<Owner> results = ownerService.findAllByFirstName(owner.getFirstName());
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("firstName", "notFound", "not found");
            return "owner/findOwners";
        }
        else if (results.size() == 1) {
            // 1 owner found
            owner = results.iterator().next();
            model.put("owners", results);
            return "redirect:/owners/" + owner.getId();
        }
        else {
            // multiple owners found
            model.put("owners", results);
            return "owners/ownersList";
        }
    }
}
