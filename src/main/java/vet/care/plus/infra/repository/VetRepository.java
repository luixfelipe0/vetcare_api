package vet.care.plus.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vet.care.plus.domain.model.vet.Vet;
import java.util.List;

public interface VetRepository extends JpaRepository<Vet, Long> {
    List<Vet> findAllByAtivoTrue();
}
