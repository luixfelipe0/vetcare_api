package vet.care.plus.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vet.care.plus.domain.model.tutor.Tutor;

import java.util.List;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    List<Tutor> findAllByAtivoTrue();
}
