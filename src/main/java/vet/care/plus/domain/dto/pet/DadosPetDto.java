package vet.care.plus.domain.dto.pet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosPetDto(
        @NotBlank
        String nome,
        @NotNull
        Integer idade,
        @NotNull
        Double peso) {
}
