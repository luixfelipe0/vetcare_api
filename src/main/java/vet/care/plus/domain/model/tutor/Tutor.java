package vet.care.plus.domain.model.tutor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.care.plus.domain.dto.tutor.AtualizacaoTutorDto;
import vet.care.plus.domain.dto.tutor.CadastroTutorDto;
import vet.care.plus.domain.model.DadosPessoais;
import vet.care.plus.domain.model.Endereco;
import vet.care.plus.domain.model.pet.Pet;

import java.util.ArrayList;
import java.util.List;

@Table(name = "tutor")
@Entity(name = "Tutor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private DadosPessoais dadosPessoais;
    @Embedded
    private Endereco endereco;
    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<Pet> pets = new ArrayList<>();
    private Boolean ativo;

    public Tutor(CadastroTutorDto dto) {
        this.dadosPessoais = new DadosPessoais(dto.dadosPessoais());
        this.endereco = new Endereco(dto.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(AtualizacaoTutorDto dto) {
        if (dto.email() != null) {
            this.dadosPessoais.atualizarEmail(dto.email());
        }
        if (dto.telefone() != null) {
            this.dadosPessoais.atualizarTelefone(dto.telefone());
        }
    }

    public void inativar() {
        this.ativo = false;
    }

    public void adicionarPet(Pet pet) {
        pet.setTutor(this);
        this.pets.add(pet);
    }
}
