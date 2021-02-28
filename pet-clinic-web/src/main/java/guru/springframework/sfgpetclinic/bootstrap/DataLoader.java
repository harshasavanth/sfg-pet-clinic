package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService){

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

    }

//    private void loadData() {
//        PetType dog = new PetType();
//        dog.setName("Dog");
//        PetType savedDogPetType = petTypeService.save(dog);
//
//        PetType cat = new PetType();
//        cat.setName("Cat");
//        PetType savedCatPetType = petTypeService.save(cat);
//
//        Speciality radiology = new Speciality();
//        radiology.setDescription("Radiology");
//        Speciality savedRadiology = specialtyService.save(radiology);
//
//        Speciality surgery = new Speciality();
//        surgery.setDescription("Surgery");
//        Speciality savedSurgery = specialtyService.save(surgery);
//
//        Speciality dentistry = new Speciality();
//        dentistry.setDescription("Dentistry");
//        Speciality savedDentistry = specialtyService.save(dentistry);
//
//        Owner owner1 = new Owner();
//        owner1.setFirstName("Harsha");
//        owner1.setLastName("Savanth");
//        owner1.setAddress("123 Kanaka Nagara");
//        owner1.setCity("Shimoga");
//        owner1.setTelephone("113161616");
//
//        Pet harshasPet = new Pet();
//        harshasPet.setPetType(savedCatPetType);
//        harshasPet.setOwner(owner1);
//        harshasPet.setBirthDate(LocalDate.now());
//        harshasPet.setName("Minchu");
//        owner1.getPets().add(harshasPet);
//
//        ownerService.save(owner1);
//
//        Owner owner2 = new Owner();
//        owner2.setFirstName("Fiona");
//        owner2.setLastName("Glenanna");
//        owner2.setAddress("baker street");
//        owner2.setCity("Miami");
//        owner2.setTelephone("6454646");
//
//        Pet fionasDog = new Pet();
//        fionasDog.setPetType(savedDogPetType);
//        fionasDog.setOwner(owner2);
//        fionasDog.setBirthDate(LocalDate.now());
//        fionasDog.setName("Shambu");
//        owner2.getPets().add(fionasDog);
//
//        ownerService.save(owner2);
//
//        Visit catVisit = new Visit();
//        catVisit.setPet(fionasDog);
//        catVisit.setDate(LocalDate.now());
//        catVisit.setDescription("Sneezy kitty");
//        visitService.save(catVisit);
//
//        System.out.println("Loaded owners...");
//
//        Vet vet1 = new Vet();
//        vet1.setFirstName("Sam");
//        vet1.setLastName("Axe");
//        vet1.getSpecialities().add(savedRadiology);
//
//        vetService.save(vet1);
//
//        Vet vet2 = new Vet();
//        vet2.setFirstName("Vinu");
//        vet2.setLastName("Savanth");
//        vet2.getSpecialities().add(savedSurgery);
//
//        vetService.save(vet2);
//
//        System.out.println("Loaded vets...");

}
