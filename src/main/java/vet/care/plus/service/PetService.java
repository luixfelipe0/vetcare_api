package vet.care.plus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.care.plus.domain.dto.pet.AtualizacaoPetDto;
import vet.care.plus.domain.dto.pet.CadastroPetDto;
import vet.care.plus.domain.dto.pet.DetalhamentoPetDto;
import vet.care.plus.domain.dto.pet.ListagemPetDto;
import vet.care.plus.domain.model.pet.Pet;
import vet.care.plus.domain.model.tutor.Tutor;
import vet.care.plus.infra.exception.PetNotFoundException;
import vet.care.plus.infra.exception.TutorNotFoundException;
import vet.care.plus.infra.repository.PetRepository;
import vet.care.plus.infra.repository.TutorRepository;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private TutorRepository tutorRepository;

    private Pet carregarPet(Long id) {
        Pet pet = null;
        try {
            pet = petRepository
                    .findById(id)
                    .orElseThrow(() -> new PetNotFoundException("Pet não encontrado."));
        } catch (PetNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pet;
    }

    public void cadastrar(CadastroPetDto dto) {
        Tutor tutor = tutorRepository
                .findById(dto.tutor())
                .orElseThrow(() -> new TutorNotFoundException("Tutor não encontrado!"));
        Pet pet = new Pet(dto, tutor);
        tutor.adicionarPet(pet);

        petRepository.save(pet);
    }

    public List<ListagemPetDto> listar() {
        return petRepository
                .findAllByAtivoTrue()
                .stream()
                .map(ListagemPetDto::new)
                .toList();
    }

    public DetalhamentoPetDto detalhar(Long id) {
        Pet pet = carregarPet(id);
        return new DetalhamentoPetDto(pet);
    }

    public void atualizar(AtualizacaoPetDto dto, Long id) {
        Pet pet = carregarPet(id);
        pet.atualizarInformacoes(dto);
    }

    public void inativar(Long id) {
        Pet pet = carregarPet(id);
        pet.inativar();
    }
}
