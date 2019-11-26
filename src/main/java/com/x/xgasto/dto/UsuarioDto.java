package com.x.xgasto.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.x.xgasto.domain.Pessoa;
import com.x.xgasto.domain.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioDto {

    private Long id;

    @NotBlank
    private Pessoa pessoa;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public UsuarioDto() {
    }

    public UsuarioDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "id=" + id +
                ", pessoa=" + pessoa +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Usuario convertDtoParaUsuario(UsuarioDto usuarioDto){
        return new Usuario(usuarioDto.email, usuarioDto.password);
    }

    public UsuarioDto convertUsuarioParaDto(Usuario usuario){
        return new UsuarioDto(usuario.getId(), usuario.getEmail(), usuario.getPassword());
    }
}

