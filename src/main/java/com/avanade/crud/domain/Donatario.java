package com.avanade.crud.domain;



import com.avanade.crud.domain.dtos.DonatarioDTO;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Donatario extends Pessoa {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "donatario")
    private List<Doacao> doacoes = new ArrayList<>();

    public Donatario() {
        super();
    }

    public Donatario(Integer id, String nome, String email, String contato) {
        super(id, nome, email, contato);
    }

    public Donatario(DonatarioDTO obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.contato = obj.getContato();


    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(List<Doacao> doacoes) {
        this.doacoes = doacoes;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
