package com.avanade.crud.services;

import com.avanade.crud.domain.Doador;
import com.avanade.crud.repositories.DoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoadorService {
    @Autowired
    private DoadorRepository doadorRepository;

    public Doador findById(Long id) {
        Optional<Doador> obj = doadorRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Objeto não encontrado! Id: "+ id));
    }

    public List<Doador> findAll() {
        return doadorRepository.findAll();
    }

    public Doador create(Doador doador){
        doador.setId(null);
        return doadorRepository.save(doador);
    }

    public Doador update (Doador doador){
        var entity = doadorRepository.findById(doador.getId()).get();
        entity.setNome(doador.getNome());
        entity.setEmail(doador.getEmail());
        entity.setContato(doador.getContato());
        return doadorRepository.save(entity);
    }

    public void delete(Long id){
        Doador doador = findById(id);
        doadorRepository.delete(doador);
    }
}
