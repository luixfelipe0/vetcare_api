package vet.care.plus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.care.plus.domain.dto.tutor.AtualizacaoTutorDto;
import vet.care.plus.domain.dto.tutor.CadastroTutorDto;
import vet.care.plus.domain.dto.tutor.DetalhamentoTutorDto;
import vet.care.plus.domain.dto.tutor.ListagemTutorDto;
import vet.care.plus.domain.model.pet.Pet;
import vet.care.plus.domain.model.tutor.Tutor;
import vet.care.plus.infra.exception.TutorNotFoundException;
import vet.care.plus.infra.repository.TutorRepository;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    private Tutor carregarTutor(Long id) {
        Tutor tutor = repository
                .findById(id)
                .orElseThrow(() -> new TutorNotFoundException("Tutor não encontrado"));
        return tutor;
    }

    public void cadastrar(CadastroTutorDto dto) {
        repository.save(new Tutor(dto));
    }

    public List<ListagemTutorDto> listar() {
        return repository
                .findAllByAtivoTrue()
                .stream()
                .map(ListagemTutorDto::new)
                .toList();
    }

    public DetalhamentoTutorDto detalhar(Long id) {
        Tutor tutor = carregarTutor(id);
        return new DetalhamentoTutorDto(tutor);
    }

    public void atualizar(AtualizacaoTutorDto dto, Long id) {
        Tutor tutor = carregarTutor(id);
        tutor.atualizarInformacoes(dto);
    }

    public void inativar(Long id) {
        Tutor tutor = carregarTutor(id);
        tutor.inativar();
        tutor.getPets().forEach(Pet::inativar);
    }
}
