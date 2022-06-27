package com.avanade.crud.resources;

import com.avanade.crud.domain.Doacao;

import com.avanade.crud.domain.Doador;
import com.avanade.crud.services.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/doacoes")
public class DoacaoResource {

    @Autowired
    private DoacaoService doacaoService;

    @GetMapping
    public ResponseEntity<List<Doacao>> findAll(){
        List<Doacao> list = doacaoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Doacao> findById(@PathVariable Long id){
        Doacao obj = doacaoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Doacao> create(@Valid @RequestBody Doacao obj){
        Doacao newObj = doacaoService.create(obj);
        return ResponseEntity.ok(newObj);
    }

    @PutMapping()
    public ResponseEntity<Doacao> update(@Valid @RequestBody Doacao obj){
        Doacao newobj = doacaoService.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Doacao> delete(@PathVariable Long id){
        doacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
