package com.avanade.crud.domain.dtos;


import com.avanade.crud.domain.Doacao;
import com.avanade.crud.domain.Donatario;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DonatarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    protected Integer id;
    @NotNull(message = "O campo NOME é requerido!")
    protected String nome;
    @Email
    @NotNull(message = "O campo EMAIL é requerido!")
    protected String email;
    @NotNull(message = "O campo CONTATO é requerido!")
    protected String contato;
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();


    public DonatarioDTO(){
        super();
    }

    public DonatarioDTO(Donatario obj){
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.contato = obj.getContato();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
