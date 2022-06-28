package com.avanade.crud.resources;

import com.avanade.crud.domain.Doacao;


import com.avanade.crud.domain.dtos.DoacaoDTO;
import com.avanade.crud.services.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/doacoes")
public class DoacaoResource {

    @Autowired
    private DoacaoService doacaoService;

    @GetMapping(value ="/{id}")
    public ResponseEntity<DoacaoDTO> findById(@PathVariable Integer id){
        Doacao obj = doacaoService.findById(id);
        return ResponseEntity.ok().body(new DoacaoDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<DoacaoDTO>> findAll(){
        List<Doacao> list = doacaoService.findAll();
        List<DoacaoDTO> listDTO = list.stream().map(obj -> new DoacaoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<DoacaoDTO> create(@Valid @RequestBody DoacaoDTO objDTO){
        Doacao obj = doacaoService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DoacaoDTO> update(@PathVariable Integer id,@Valid
    @RequestBody DoacaoDTO objDTO){
        Doacao newObj = doacaoService.update(id, objDTO);
        return ResponseEntity.ok().body(new DoacaoDTO(newObj));
    }
}
