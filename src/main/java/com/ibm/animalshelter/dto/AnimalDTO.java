package com.ibm.animalshelter.dto;

import com.ibm.animalshelter.model.collection.Animal;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class AnimalDTO {


    @Id
    private String id;

    @Pattern(regexp = "[A-Za-z ]+$", message = "O campo deve conter apenas letras")
    @NotBlank(message = "O campo deve ser preenchido")
    private String nome;

    @Pattern(regexp = "[A-Za-z ]+$", message = "O campo deve conter apenas letras")
    @NotBlank(message = "O campo deve ser preenchido")
    private String tipo;

    @Pattern(regexp = "[A-Za-z ]+$", message = "O campo deve conter apenas letras")
    @NotBlank(message = "O campo deve ser preenchido")
    private String raca;

    @Pattern(regexp = "[A-Za-z ]+$", message = "O campo deve conter apenas letras")
    @NotBlank(message = "O campo deve ser preenchido")
    private String sexo;

    @NotBlank(message = "O campo deve ser preenchido")
    private int idade;

    private boolean castrado;

    public Animal transformaParaObjeto(){

        return new Animal(id, nome, tipo, raca, sexo, idade, castrado);
    }

    public AnimalDTO() {

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
