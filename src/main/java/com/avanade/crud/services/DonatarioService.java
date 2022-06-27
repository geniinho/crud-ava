package com.avanade.crud.services;

import com.avanade.crud.domain.Donatario;
import com.avanade.crud.repositories.DonatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonatarioService {
    @Autowired
    private DonatarioRepository donatarioRepository;

    public Donatario findById(Long id) {
        Optional<Donatario> obj = donatarioRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Objeto não encontrado! Id: "+ id));
    }

    public List<Donatario> findAll() {
        return donatarioRepository.findAll();
    }

    public Donatario create(Donatario donatario){
        donatario.setId(null);
        return donatarioRepository.save(donatario);
    }

    public Donatario update (Donatario donatario){
        var entity = donatarioRepository.findById(donatario.getId()).get();
        entity.setNome(donatario.getNome());
        entity.setEmail(donatario.getEmail());
        entity.setContato(donatario.getContato());
        return donatarioRepository.save(entity);
    }

    public void delete(Long id){
        Donatario donatario = findById(id);
        donatarioRepository.delete(donatario);
    }
}
