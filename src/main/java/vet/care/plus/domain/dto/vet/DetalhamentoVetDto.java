package vet.care.plus.domain.dto.vet;

import vet.care.plus.domain.model.DadosPessoais;
import vet.care.plus.domain.model.Endereco;
import vet.care.plus.domain.model.vet.Especialidade;
import vet.care.plus.domain.model.vet.Vet;

public record DetalhamentoVetDto(Long id, DadosPessoais dadosPessoais, String crmv, Especialidade especialidade, Endereco endereco, Boolean ativo) {

    public DetalhamentoVetDto(Vet vet) {
        this(vet.getId(), vet.getDadosPessoais(), vet.getCrmv(), vet.getEspecialidade(), vet.getEndereco(), vet.getAtivo());
    }

}
