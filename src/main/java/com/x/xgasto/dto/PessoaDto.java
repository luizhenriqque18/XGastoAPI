package com.x.xgasto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.x.xgasto.domain.Pessoa;
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

    @NotBlank(message = "Sexo não poder ser vazio")
    @ValidateEnum(targetClassType = SexoEnum.class, message = "Sexo deve conter um opção M ou F.")
    private String sexo;

    public PessoaDto(Long id, String nome, String sexo) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
    }

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

    public Pessoa convertDtoParaPessoa(PessoaDto pessoaDto){
        return new Pessoa(
                pessoaDto.getNome(),
                SexoEnum.valueOf(pessoaDto.getSexo())
        );
    }

    public PessoaDto convertPessoaParaDto(Pessoa pessoa){
        return new PessoaDto(
                pessoa.getId(),
                pessoa.getNome(),
                String.valueOf(pessoa.getSexo())
        );
    }
}
