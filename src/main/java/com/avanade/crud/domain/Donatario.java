package com.avanade.crud.domain;



import javax.persistence.Entity;
import javax.persistence.OneToMany;
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

    public Donatario(Long id, String nome, String email, String contato) {
        super(id, nome, email, contato);
    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(List<Doacao> doacoes) {
        this.doacoes = doacoes;
    }
}
