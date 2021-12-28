package com.ibm.animalshelter.model.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "animal")
public class Animal {

    @Id
    private String id;

    @NotBlank
    private String nome;

    @NotBlank
    private String tipo;

    @NotBlank
    private String raca;

    @NotBlank
    private String sexo;

    @NotNull
    private int idade;

    @NotBlank
    private boolean castrado;

    public Animal(String id, String nome, String tipo, String raca, String sexo, int idade, boolean castrado) {

        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.raca = raca;
        this.sexo = sexo;
        this.idade = idade;
        this.castrado = castrado;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }
}
