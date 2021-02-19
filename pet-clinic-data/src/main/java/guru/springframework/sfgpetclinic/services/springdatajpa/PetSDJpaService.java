package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.PetReposiroty;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

    private final PetReposiroty petReposiroty;

    public PetSDJpaService(PetReposiroty petReposiroty) {
        this.petReposiroty = petReposiroty;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petReposiroty.findAll().forEach(pets::add);
        return pets;

    }

    @Override
    public Pet findById(Long aLong) {
        return petReposiroty.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petReposiroty.save(object);
    }

    @Override
    public void delete(Pet object) {
        petReposiroty.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petReposiroty.deleteById(aLong);
    }
}
