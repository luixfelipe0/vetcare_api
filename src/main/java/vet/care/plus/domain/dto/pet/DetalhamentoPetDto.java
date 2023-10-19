package vet.care.plus.domain.dto.pet;

import vet.care.plus.domain.model.Endereco;
import vet.care.plus.domain.model.pet.Pet;
import vet.care.plus.domain.model.pet.TipoPet;

public record DetalhamentoPetDto(Long id, String nome, Integer idade, Double peso, TipoPet tipo, boolean ativo, String nomeTutor, String telefoneTutor, Endereco enderecoTutor) {

    public DetalhamentoPetDto(Pet pet) {
        this(
                pet.getId(),
                pet.getDadosPet().getNome(),
                pet.getDadosPet().getIdade(),
                pet.getDadosPet().getPeso(),
                pet.getTipo(), pet.isAtivo(),
                pet.getTutor().getDadosPessoais().getNome(),
                pet.getTutor().getDadosPessoais().getTelefone(),
                pet.getTutor().getEndereco());
    }

}
