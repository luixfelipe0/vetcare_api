package vet.care.plus.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.care.plus.domain.dto.EnderecoDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable
public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String numero;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDto dto) {
        this.cep = dto.cep();
        this.logradouro = dto.logradouro();
        this.complemento = dto.complemento();
        this.bairro = dto.bairro();
        this.numero = dto.numero();
        this.cidade = dto.cidade();
        this.uf = dto.uf();
    }

    public void atualizarEndereco(EnderecoDto dto) {
        if(dto.cep() != null) {
            this.cep = dto.cep();
        }
        if(dto.logradouro() != null) {
            this.logradouro = dto.logradouro();
        }
        if(dto.complemento() != null) {
            this.complemento = dto.complemento();
        }
        if(dto.bairro() != null) {
            this.bairro = dto.bairro();
        }
        if(dto.numero() != null) {
            this.numero = dto.numero();
        }
        if(dto.cidade() != null) {
            this.cidade = dto.cidade();
        }
        if(dto.uf() != null) {
            this.uf = dto.uf();
        }
    }

}
