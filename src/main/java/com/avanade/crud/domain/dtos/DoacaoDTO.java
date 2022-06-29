package com.avanade.crud.domain.dtos;

import com.avanade.crud.domain.Doacao;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class DoacaoDTO implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDoacao = LocalDate.now();
    @NotNull(message = "O campo TÍTULO é requerido!")
    private String titulo;
    @NotNull(message = "O campo OBSERVAÇÕES é requerido!")
    private String observacoes;
    @NotNull(message = "O campo DOADOR é requerido!")
    private Integer doador;
    @NotNull(message = "O campo DONATÁRIO é requerido!")
    private Integer donatario;
    private String nomeDoador;
    private String nomeDonatario;

    public DoacaoDTO() {
    }

    public DoacaoDTO(Doacao obj){
        this.id = obj.getId();
        this.dataDoacao = obj.getDataDoacao();
        this.titulo = obj.getTitulo();
        this.observacoes = obj.getObservacoes();
        this.doador = obj.getDoador().getId();
        this.donatario = obj.getDonatario().getId();
        this.nomeDoador = obj.getDoador().getNome();
        this.nomeDonatario = obj.getDonatario().getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(LocalDate dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getDoador() {
        return doador;
    }

    public void setDoador(Integer doador) {
        this.doador = doador;
    }

    public Integer getDonatario() {
        return donatario;
    }

    public void setDonatario(Integer donatario) {
        this.donatario = donatario;
    }

    public String getNomeDoador() {
        return nomeDoador;
    }

    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }

    public String getNomeDonatario() {
        return nomeDonatario;
    }

    public void setNomeDonatario(String nomeDonatario) {
        this.nomeDonatario = nomeDonatario;
    }
}
