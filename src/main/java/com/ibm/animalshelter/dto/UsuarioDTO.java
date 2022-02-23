package com.ibm.animalshelter.dto;


import com.ibm.animalshelter.model.collection.Abrigo;
import com.ibm.animalshelter.model.collection.Usuario;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UsuarioDTO {


    @Id
    private String id;

    @NotBlank(message = "O campo deve ser preenchido")
    private String usuario;

    @Pattern(regexp = "[A-Za-z0-9+_.-]+@(.+)$", message = "E-mail inválido")
    @NotBlank(message = "O campo deve ser preenchido")
    private String email;

    @NotBlank(message = "O campo deve ser preenchido")
    private String senha;

    public Usuario transformaParaObjeto(){

        return new Usuario(id, usuario, email, senha);
    }

    public UsuarioDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
