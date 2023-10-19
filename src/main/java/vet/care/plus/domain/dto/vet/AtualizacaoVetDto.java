package vet.care.plus.domain.dto.vet;

import vet.care.plus.domain.dto.EnderecoDto;

public record AtualizacaoVetDto(String email, String telefone, EnderecoDto endereco) {
}
