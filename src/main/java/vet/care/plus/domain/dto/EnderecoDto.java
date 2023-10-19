package vet.care.plus.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDto(
        @NotBlank
        String cep,
        @NotBlank
        String logradouro,
        String complemento,
        @NotBlank
        String bairro,
        @NotBlank
        String numero,
        @NotBlank
        String cidade,
        @NotBlank
        String uf) {
}
