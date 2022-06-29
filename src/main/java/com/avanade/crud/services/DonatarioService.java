package com.avanade.crud.services;


import com.avanade.crud.domain.Doador;
import com.avanade.crud.domain.Donatario;

import com.avanade.crud.domain.dtos.DonatarioDTO;
import com.avanade.crud.repositories.DonatarioRepository;
import com.avanade.crud.repositories.PessoaRepository;
import com.avanade.crud.services.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class DonatarioService {
    @Autowired
    private DonatarioRepository donatarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Donatario findById(Integer id) {
        Optional<Donatario> obj = donatarioRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Objeto não encontrado! Id: "+ id));
    }

    public List<Donatario> findAll() {
        return donatarioRepository.findAll();
    }

    public Donatario create(DonatarioDTO objDTO){
        objDTO.setId(null);
        validaPorEmail(objDTO);
        Donatario newObj = new Donatario(objDTO);
        return donatarioRepository.save(newObj);
    }

    public Donatario update (Integer id, @Valid DonatarioDTO objDTO){
        objDTO.setId(id);
        Donatario oldObj = findById(id);
        validaPorEmail(objDTO);
        oldObj = new Donatario(objDTO);
        return donatarioRepository.save(oldObj);
    }

    public void delete(Integer id){
        Donatario donatario = findById(id);
        if(donatario.getDoacoes().size()>0) {
            throw new DataIntegrityViolationException("O Donatario já recebeu doações e não pode ser deletado!");
        }
        donatarioRepository.deleteById(id);
    }

    private void validaPorEmail(DonatarioDTO objDTO) {
        Optional<Donatario> obj = donatarioRepository.findByEmail(objDTO.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }
}
