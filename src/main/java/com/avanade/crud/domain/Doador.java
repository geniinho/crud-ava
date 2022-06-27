package com.avanade.crud.domain;



import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="doador")
public class Doador extends Pessoa {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "doador")
    private List<Doacao> doacao = new ArrayList<>();

    public Doador() {
        super();
    }

    public Doador(Long id, String nome, String email, String contato) {
        super(id, nome, email, contato);
    }

    public List<Doacao> getDoacao() {
        return doacao;
    }

    public void setDoacao(List<Doacao> chamados) {
        this.doacao = doacao;
    }
}
