package com.avanade.crud.services;

import com.avanade.crud.domain.Doador;

import com.avanade.crud.domain.dtos.DoadorDTO;
import com.avanade.crud.repositories.DoadorRepository;
import com.avanade.crud.repositories.PessoaRepository;
import com.avanade.crud.services.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class DoadorService {

    @Autowired
    private DoadorRepository doadorRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Doador findById(Integer id) {
        Optional<Doador> obj = doadorRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Objeto não encontrado! Id: "+ id));
    }

    public List<Doador> findAll() {
        return doadorRepository.findAll();
    }

    public Doador create(DoadorDTO objDTO){
        objDTO.setId(null);
        validaPorEmail(objDTO);
        Doador newObj = new Doador(objDTO);
        return doadorRepository.save(newObj);
    }

    public Doador update (Integer id, @Valid DoadorDTO objDTO){
        objDTO.setId(id);
        Doador oldObj = findById(id);
        return doadorRepository.save(oldObj);
    }

    public void delete(Integer id){
        Doador doador = findById(id);
        if(doador.getDoacao().size()>0) {
            throw new DataIntegrityViolationException("O Doador possui doações e não pode ser deletado!");
        }
        doadorRepository.deleteById(id);
    }

    private void validaPorEmail(DoadorDTO objDTO) {
        Optional<Doador> obj = doadorRepository.findByEmail(objDTO.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }
}
