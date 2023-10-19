package vet.care.plus.domain.dto.tutor;

import vet.care.plus.domain.model.tutor.Tutor;


public record ListagemTutorDto(Long id, String nome, String email, String telefone) {

    public ListagemTutorDto(Tutor tutor) {
        this(tutor.getId(),
                tutor.getDadosPessoais().getNome(),
                tutor.getDadosPessoais().getEmail(),
                tutor.getDadosPessoais().getTelefone());
    }

}
