package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }



    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", new Owner());
        return "/owners/findOwners";
    }

    @GetMapping()
    public String processFindForm(Owner owner, BindingResult result, Model model){
        if(owner.getLastName() == null){
            owner.setLastName("");
        }

        List<Owner> results = ownerService.findByLastNameLike("%" + owner.getLastName() + "%");
        if (results.isEmpty()){
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }else if (results.size() == 1){
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        }else{
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }
    
    @GetMapping("/{ownerID}")
    public ModelAndView showOwner(@PathVariable("ownerID") Long ownerID){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerID));
        return mav;
    }
}
