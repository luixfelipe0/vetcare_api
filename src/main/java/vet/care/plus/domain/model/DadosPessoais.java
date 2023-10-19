package vet.care.plus.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.care.plus.domain.dto.DadosPessoaisDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class DadosPessoais {

    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String sexo;

    public DadosPessoais(DadosPessoaisDto dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.cpf = dto.cpf();
        this.sexo = dto.sexo();
    }

    public void atualizarEmail(String email) {
        if(email != null) {
            this.email = email;
        }
    }

    public void atualizarTelefone(String telefone) {
        if(telefone != null) {
            this.telefone = telefone;
        }
    }

}
