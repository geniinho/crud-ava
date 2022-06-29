package com.avanade.crud.domain;



import com.avanade.crud.domain.dtos.DoadorDTO;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Doador extends Pessoa {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "doador")
    private List<Doacao> doacoes = new ArrayList<>();

    public Doador() {
        super();
    }

    public Doador(Integer id, String nome, String email, String contato) {
        super(id, nome, email, contato);
    }

    public Doador(DoadorDTO obj){
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.contato = obj.getContato();
    }

    public List<Doacao> getDoacao() {
        return doacoes;
    }

    public void setDoacao(List<Doacao> chamados) {
        this.doacoes = doacoes;
    }
}
