package com.avanade.crud.services;

import com.avanade.crud.domain.Doacao;
import com.avanade.crud.domain.Doador;
import com.avanade.crud.domain.Donatario;
import com.avanade.crud.repositories.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class DoacaoService {
    @Autowired
    private DoacaoRepository doacaoRepository;

    @Autowired
    private DoadorService doadorService;

    @Autowired
    private DonatarioService donatarioService;

    public Doacao findById(Long id) {
        Optional<Doacao> obj = doacaoRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Objeto não encontrado! Id: "+ id));
    }

    public List<Doacao> findAll() {
        return doacaoRepository.findAll();
    }

    public Doacao create(@Valid Doacao doacao){
        return doacaoRepository.save(doacao);
    }

    public Doacao update (Doacao doacao){
        var entity = doacaoRepository.findById(doacao.getId()).get();
        entity.setTitulo(doacao.getTitulo());
        entity.setObservacoes(doacao.getObservacoes());
        entity.setDoador(doacao.getDoador());
        entity.setDonatario(doacao.getDonatario());
        return doacaoRepository.save(entity);
    }

    public void delete(Long id){
        Doacao doacao = findById(id);
        doacaoRepository.delete(doacao);
    }

}
