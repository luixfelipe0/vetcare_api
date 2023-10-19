package vet.care.plus.domain.dto.vet;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import vet.care.plus.domain.dto.DadosPessoaisDto;
import vet.care.plus.domain.dto.EnderecoDto;
import vet.care.plus.domain.model.vet.Especialidade;

public record CadastroVetDto(
        @Valid
        @NotNull
        DadosPessoaisDto dadosPessoais,
        @NotBlank
        String crmv,
        @NotNull
        Especialidade especialidade,
        @Valid
        @NotNull
        EnderecoDto endereco) {
}
