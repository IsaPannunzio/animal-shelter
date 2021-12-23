package com.ibm.animalshelter.model.collections;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Animal {

    @Id
    private String codigo;

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

    public Animal(String codigo, String nome, String tipo, String raca, String sexo, int idade, boolean castrado) {

        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.raca = raca;
        this.sexo = sexo;
        this.idade = idade;
        this.castrado = castrado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
