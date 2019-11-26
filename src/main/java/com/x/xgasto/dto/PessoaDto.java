package com.x.xgasto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.domain.Usuario;
import com.x.xgasto.enums.SexoEnum;
import com.x.xgasto.validator.ValidateEnum;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;


public class PessoaDto {

    @JsonIgnore
    private Long id;

    private Usuario usuario;

    @NotBlank(message = "Nome não poder ser vazio")
    @Length(min = 5, max = 200, message = "Nome deve conter entre 5 e 200 caracteres.")
    private String nome;

    @ValidateEnum(targetClassType = SexoEnum.class, message = "Sexo deve conter um opção M ou F.")
    private String sexo;

    public PessoaDto(Long id, Usuario usuario, String nome, String sexo) {
        this.id = id;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        return new Pessoa();
    }

    public PessoaDto convertPessoaParaDto(Pessoa pessoa){
        return new PessoaDto(
                pessoa.getId(),
                pessoa.getUsuario(),
                pessoa.getNome(),
                String.valueOf(pessoa.getSexo())
        );
    }
}
