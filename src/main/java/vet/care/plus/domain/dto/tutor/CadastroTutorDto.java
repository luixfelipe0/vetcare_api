package vet.care.plus.domain.dto.tutor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import vet.care.plus.domain.dto.DadosPessoaisDto;
import vet.care.plus.domain.dto.EnderecoDto;


public record CadastroTutorDto(
        @Valid
        @NotNull
        DadosPessoaisDto dadosPessoais,
        @Valid
        @NotNull
        EnderecoDto endereco) {
}
