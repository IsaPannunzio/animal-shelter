package com.ibm.animalshelter.dto;


import com.ibm.animalshelter.model.collection.Abrigo;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class AbrigoDTO {


    @Id
    private String id;

    @Pattern(regexp = "[A-Za-z ]+$", message = "O campo deve conter apenas letras")
    @NotBlank(message = "O campo deve ser preenchido")
    private String nome;

    @NotBlank(message = "O campo deve ser preenchido")
    private String endereco;

    @Pattern(regexp = "[0-9]+$", message = "O campo deve conter apenas números")
    @NotBlank(message = "O campo deve ser preenchido")
    private String telefone;

    public Abrigo transformaParaObjeto(){

        return new Abrigo(id, nome, endereco, telefone);
    }

    public AbrigoDTO() {

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
