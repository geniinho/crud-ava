package com.avanade.crud.services;

import com.avanade.crud.domain.Doacao;
import com.avanade.crud.repositories.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoacaoService {
    @Autowired
    private DoacaoRepository doacaoRepository;


    public Doacao findById(Long id) {
        Optional<Doacao> obj = doacaoRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Objeto não encontrado! Id: "+ id));
    }

    public List<Doacao> findAll() {
        return doacaoRepository.findAll();
    }

    public Doacao create(Doacao doacao){
        doacao.setId(null);
        return doacaoRepository.save(doacao);
    }

    public Doacao update (Long id,Doacao doacao){
        doacao.setId(id);
        return doacaoRepository.save(doacao);
    }

}
