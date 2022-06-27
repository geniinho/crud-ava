package com.avanade.crud.resources;

import com.avanade.crud.domain.Doador;
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

    @GetMapping
    public ResponseEntity<List<Doador>> findAll(){
        List<Doador> list = doadorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Doador> findById(@PathVariable Long id){
        Doador obj = doadorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Doador> create(@Valid @RequestBody Doador obj){
        Doador newObj = doadorService.create(obj);
        return ResponseEntity.ok(newObj);
    }

    @PutMapping()
    public ResponseEntity<Doador> update(@Valid @RequestBody Doador obj){
        Doador newobj = doadorService.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Doador> delete(@PathVariable Long id){
        doadorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
