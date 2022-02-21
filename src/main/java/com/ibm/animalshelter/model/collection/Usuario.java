package com.ibm.animalshelter.model.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Document(collection = "usuario")
public class Usuario {

    @Id
    private String id;

    @NotBlank(message = "O campo deve ser preenchido")
    private String usuario;

    @NotBlank(message = "O campo deve ser preenchido")
    @Pattern(regexp = "[A-Za-z0-9+_.-]+@(.+)$", message = "E-mail inválido")
    private String email;

    @NotBlank(message = "O campo deve ser preenchido")
    private String senha;

    public Usuario(String id, String usuario, String email, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
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
