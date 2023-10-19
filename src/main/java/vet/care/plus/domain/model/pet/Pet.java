package vet.care.plus.domain.model.pet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.care.plus.domain.dto.pet.AtualizacaoPetDto;
import vet.care.plus.domain.dto.pet.CadastroPetDto;
import vet.care.plus.domain.model.tutor.Tutor;

@Table(name = "pet")
@Entity(name = "Pet")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private DadosPet dadosPet;
    @Enumerated(EnumType.STRING)
    private TipoPet tipo;
    private boolean ativo;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tutor")
    private Tutor tutor;

    public Pet(CadastroPetDto dto, Tutor tutor) {
        this.dadosPet = new DadosPet(dto.dadosPet());
        this.tipo = dto.tipo();
        this.ativo = true;
    }

    public void atualizarInformacoes(AtualizacaoPetDto dto) {
        if(dto.nome() != null) {
            this.dadosPet.atualizarNome(dto.nome());
        }
        if(dto.idade() != null) {
            this.dadosPet.atualizarIdade(dto.idade());
        }
        if(dto.peso() != null) {
            this.dadosPet.atualizarPeso(dto.peso());
        }
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public void inativar() {
        this.ativo = false;
    }


}
