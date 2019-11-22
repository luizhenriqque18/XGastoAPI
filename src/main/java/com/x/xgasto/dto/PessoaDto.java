package com.x.xgasto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.x.xgasto.enums.SexoEnum;
import com.x.xgasto.validator.ValidateEnum;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;


public class PessoaDto {

    @JsonIgnore
    private Long id;

    @NotBlank(message = "Nome não poder ser vazio")
    @Length(min = 5, max = 200, message = "Nome deve conter entre 5 e 200 caracteres.")
    private String nome;

    @ValidateEnum(targetClassType = SexoEnum.class, message = "Sexo deve conter um opção M ou F.")
    private String sexo;

    public PessoaDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "PessoaDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                '}';
    }
}
