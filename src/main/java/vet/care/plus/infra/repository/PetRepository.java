package vet.care.plus.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vet.care.plus.domain.model.pet.Pet;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findAllByAtivoTrue();
}
