package com.ibm.animalshelter.model.collection;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "voluntario")
public class Voluntario {

    @Schema(description = "Identificador único do voluntário")
    @Id
    private String id;

    @Schema(description = "Nome do voluntário")
    private String nome;

    @Schema(description = "Endereço do voluntário")
    private String endereco;

    @Schema(description = "Telefone do voluntário")
    private String telefone;

    public Voluntario(String id, String nome, String endereco, String telefone) {

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
