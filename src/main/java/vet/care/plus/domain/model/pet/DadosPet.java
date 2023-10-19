package vet.care.plus.domain.model.pet;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.care.plus.domain.dto.pet.DadosPetDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class DadosPet {

    private String nome;
    private Integer idade;
    private Double peso;

    public DadosPet(DadosPetDto dto) {
        this.nome = dto.nome();
        this.idade = dto.idade();
        this.peso = dto.peso();
    }

    public void atualizarNome(String nome) {
        this.nome = nome;
    }

    public void atualizarIdade(Integer idade) {
        this.idade = idade;
    }

    public void atualizarPeso(Double peso) {
        this.peso = peso;
    }
}
