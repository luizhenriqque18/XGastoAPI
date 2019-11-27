package com.x.xgasto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.x.xgasto.domain.Conta;
import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.domain.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class UsuarioDto {

    private Long id;

    private List<Conta> conta;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @JsonIgnore
    private String password;

    public UsuarioDto() {
    }

    public UsuarioDto(Long id, List<Conta> conta, @Email @NotBlank String email) {
        this.id = id;
        this.conta = conta;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Conta> getConta() { return conta; }

    public void setConta(List<Conta> conta) { this.conta = conta; }

    public Usuario convertDtoParaUsuario(UsuarioDto usuarioDto){
        return new Usuario(usuarioDto.email, usuarioDto.password);
    }

    public UsuarioDto convertUsuarioParaDto(Usuario usuario){
        return new UsuarioDto(usuario.getId(), usuario.getConta(),usuario.getEmail());
    }
}

