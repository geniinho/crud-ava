package com.avanade.crud.resources;

import com.avanade.crud.domain.Doador;
import com.avanade.crud.domain.dtos.DoadorDTO;
import com.avanade.crud.services.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/doadores")
public class DoadorResource {

    @Autowired
    private DoadorService doadorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DoadorDTO> findById(@PathVariable Integer id){
        Doador obj = doadorService.findById(id);
        return ResponseEntity.ok().body(new DoadorDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<DoadorDTO>> findAll(){
        List<Doador> list = doadorService.findAll();
        List<DoadorDTO> listDTO = list.stream().map(obj -> new DoadorDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<DoadorDTO> create(@Valid @RequestBody DoadorDTO objDTO){
        Doador newObj = doadorService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DoadorDTO> update(@PathVariable Integer id, @Valid @RequestBody DoadorDTO objDTO){
        Doador obj = doadorService.update(id, objDTO);
        return ResponseEntity.ok().body(new DoadorDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DoadorDTO> delete(@PathVariable Integer id){
        doadorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
