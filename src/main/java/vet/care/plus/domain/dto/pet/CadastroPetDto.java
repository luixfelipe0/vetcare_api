package vet.care.plus.domain.dto.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import vet.care.plus.domain.model.pet.TipoPet;

public record CadastroPetDto(

        @NotNull
        @Valid
        DadosPetDto dadosPet,
        @NotNull
        TipoPet tipo,
        @JsonProperty("id_tutor")
        @NotNull
        Long tutor) {
}
