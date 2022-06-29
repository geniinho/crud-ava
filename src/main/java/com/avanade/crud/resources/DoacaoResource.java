package com.avanade.crud.resources;

import com.avanade.crud.domain.Doacao;


import com.avanade.crud.domain.dtos.DoacaoDTO;
import com.avanade.crud.services.DoacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "API REST Doações")
@CrossOrigin(origins = "*")
public class DoacaoResource {

    @Autowired
    private DoacaoService doacaoService;

    @ApiOperation(value="Retorna uma doação unica usando ID")
    @GetMapping(value ="/{id}")
    public ResponseEntity<DoacaoDTO> findById(@PathVariable Integer id){
        Doacao obj = doacaoService.findById(id);
        return ResponseEntity.ok().body(new DoacaoDTO(obj));
    }

    @GetMapping
    @ApiOperation(value="Retorna uma lista com todas as doações")
    public ResponseEntity<List<DoacaoDTO>> findAll(){
        List<Doacao> list = doacaoService.findAll();
        List<DoacaoDTO> listDTO = list.stream().map(obj -> new DoacaoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    @ApiOperation(value="Cadastra uma doação")
    public ResponseEntity<DoacaoDTO> create(@Valid @RequestBody DoacaoDTO objDTO){
        Doacao obj = doacaoService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value="Atualiza uma doação")
    public ResponseEntity<DoacaoDTO> update(@PathVariable Integer id,@Valid
    @RequestBody DoacaoDTO objDTO){
        Doacao newObj = doacaoService.update(id, objDTO);
        return ResponseEntity.ok().body(new DoacaoDTO(newObj));
    }
}
