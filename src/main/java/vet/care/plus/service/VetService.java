package vet.care.plus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.care.plus.domain.dto.vet.AtualizacaoVetDto;
import vet.care.plus.domain.dto.vet.CadastroVetDto;
import vet.care.plus.domain.dto.vet.DetalhamentoVetDto;
import vet.care.plus.domain.dto.vet.ListagemVetDto;
import vet.care.plus.domain.model.vet.Vet;
import vet.care.plus.infra.exception.VetNotFoundException;
import vet.care.plus.infra.repository.VetRepository;

import java.util.List;

@Service
public class VetService {

    @Autowired
    private VetRepository repository;

    public Vet carregarVet(Long id) {
        Vet vet = repository
                .findById(id)
                .orElseThrow(() ->  new VetNotFoundException("Veterinário não encontrado"));
        return vet;
    }

    public void cadastrar(CadastroVetDto dto) {
        repository.save(new Vet(dto));
    }

    public List<ListagemVetDto> listar() {
        return repository
                .findAllByAtivoTrue()
                .stream()
                .map(ListagemVetDto::new)
                .toList();
    }

    public DetalhamentoVetDto detalhar(Long id) {
        Vet vet = carregarVet(id);
        return new DetalhamentoVetDto(vet);
    }

    public void atualizar(AtualizacaoVetDto dto, Long id) {
        Vet vet = carregarVet(id);
        vet.atualizarInformacoes(dto);
    }

    public void inativar(Long id) {
        Vet vet = carregarVet(id);
        vet.inativar();
    }
}
