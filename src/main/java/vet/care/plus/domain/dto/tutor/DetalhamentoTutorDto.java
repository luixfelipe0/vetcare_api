package vet.care.plus.domain.dto.tutor;

import vet.care.plus.domain.model.DadosPessoais;
import vet.care.plus.domain.model.Endereco;
import vet.care.plus.domain.model.pet.Pet;
import vet.care.plus.domain.model.tutor.Tutor;

import java.util.List;


public record DetalhamentoTutorDto(Long id, DadosPessoais dadosPessoais, Endereco endereco, Boolean ativo, List<Pet> pets) {

    public DetalhamentoTutorDto(Tutor tutor) {
        this(tutor.getId(), tutor.getDadosPessoais(), tutor.getEndereco(), tutor.getAtivo(), tutor.getPets());
    }

}
