package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Harsha");
        owner1.setLastName("Savanth");
        owner1.setAddress("123 Kanaka Nagara");
        owner1.setCity("Shimoga");
        owner1.setTelephone("113161616");

        Pet harshasPet = new Pet();
        harshasPet.setPetType(savedCatPetType);
        harshasPet.setOwner(owner1);
        harshasPet.setBirtDate(LocalDate.now());
        harshasPet.setName("Minchu");
        owner1.getPets().add(harshasPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanna");
        owner2.setAddress("baker street");
        owner2.setCity("Miami");
        owner2.setTelephone("6454646");

        Pet fionasDog = new Pet();
        fionasDog.setPetType(savedDogPetType);
        fionasDog.setOwner(owner2);
        fionasDog.setBirtDate(LocalDate.now());
        fionasDog.setName("Shambu");
        owner2.getPets().add(fionasDog);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Vinu");
        vet2.setLastName("Savanth");

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
