package com.ibm.animalshelter.model.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Document(collection = "abrigo")
public class Abrigo {

    @Id
    private String id;

    @NotBlank(message = "O campo deve ser preenchido")
    @Pattern(regexp = "[A-Za-z ]+$", message = "O campo deve conter apenas letras")
    private String nome;

    @NotBlank(message = "O campo deve ser preenchido")
    private String endereco;

    @NotBlank(message = "O campo deve ser preenchido")
    @Pattern(regexp = "[0-9]+$", message = "O campo deve conter apenas números")
    private String telefone;

    public Abrigo(String id, String nome, String endereco, String telefone) {

        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}



