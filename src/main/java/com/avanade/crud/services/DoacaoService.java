package com.avanade.crud.services;

import com.avanade.crud.domain.Doacao;
import com.avanade.crud.domain.Doador;
import com.avanade.crud.domain.Donatario;
import com.avanade.crud.domain.dtos.DoacaoDTO;
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

    public Doacao findById(Integer id) {
        Optional<Doacao> obj = doacaoRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Objeto não encontrado! Id: "+ id));
    }

    public List<Doacao> findAll() {
        return doacaoRepository.findAll();
    }

    public Doacao create(@Valid DoacaoDTO doacaoDTO){
        return doacaoRepository.save(newDoacao(doacaoDTO));
    }

    public Doacao update (Integer id,@Valid DoacaoDTO objDTO){
        objDTO.setId(id);
        Doacao oldObj = findById(id);
        oldObj = newDoacao(objDTO);
        return doacaoRepository.save(oldObj);
    }


    private Doacao newDoacao(DoacaoDTO obj){
        Doador doador = doadorService.findById(obj.getDoador());
        Donatario donatario = donatarioService.findById(obj.getDonatario());
        Doacao doacao = new Doacao();
        doacao.setTitulo(obj.getTitulo());
        doacao.setObservacoes(obj.getObservacoes());
        doacao.setDoador(doador);
        doacao.setDonatario(donatario);
        return doacao;

    }
}
