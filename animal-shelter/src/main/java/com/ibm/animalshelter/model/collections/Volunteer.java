package com.ibm.animalshelter.model.collections;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

public class Volunteer {

    @Id
    private String cpf;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereco;

    @NotBlank
    private String telefone;

    public Volunteer(String cpf, String nome, String endereco, String telefone) {

        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
