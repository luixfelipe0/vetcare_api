package vet.care.plus.domain.model.vet;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.care.plus.domain.dto.vet.AtualizacaoVetDto;
import vet.care.plus.domain.dto.vet.CadastroVetDto;
import vet.care.plus.domain.model.DadosPessoais;
import vet.care.plus.domain.model.Endereco;

@Table(name = "vet")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private DadosPessoais dadosPessoais;
    private String crmv;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Vet(CadastroVetDto dto) {
        this.dadosPessoais = new DadosPessoais(dto.dadosPessoais());
        this.crmv = dto.crmv();
        this.especialidade = dto.especialidade();
        this.endereco = new Endereco(dto.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(AtualizacaoVetDto dto) {
        if(dto.email() != null) {
            this.dadosPessoais.atualizarEmail(dto.email());
        }
        if(dto.telefone() != null) {
            this.dadosPessoais.atualizarTelefone(dto.telefone());
        }
        if(dto.endereco() != null) {
            this.endereco.atualizarEndereco(dto.endereco());
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
