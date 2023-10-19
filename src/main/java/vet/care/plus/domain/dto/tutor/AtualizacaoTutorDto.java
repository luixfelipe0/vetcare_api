package vet.care.plus.domain.dto.tutor;

import vet.care.plus.domain.model.Endereco;

public record AtualizacaoTutorDto(String email, String telefone, Endereco endereco) {
}
