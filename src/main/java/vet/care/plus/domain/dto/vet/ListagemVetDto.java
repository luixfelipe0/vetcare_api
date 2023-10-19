package vet.care.plus.domain.dto.vet;

import vet.care.plus.domain.model.vet.Especialidade;
import vet.care.plus.domain.model.vet.Vet;

public record ListagemVetDto(Long id, String nome, String email, String crmv, Especialidade especialidade) {

    public ListagemVetDto(Vet vet) {
        this(vet.getId(),
                vet.getDadosPessoais().getNome(),
                vet.getDadosPessoais().getEmail(),
                vet.getCrmv(),
                vet.getEspecialidade());
    }

}
