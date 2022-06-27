package com.avanade.crud.resources;

import com.avanade.crud.domain.Donatario;
import com.avanade.crud.services.DonatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/donatarios")
public class DonatarioResource {
    @Autowired
    private DonatarioService donatarioService;

    @GetMapping
    public ResponseEntity<List<Donatario>> findAll(){
        List<Donatario> list = donatarioService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Donatario> findById(@PathVariable Long id){
        Donatario obj = donatarioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Donatario> create(@Valid @RequestBody Donatario obj){
        Donatario newObj = donatarioService.create(obj);
        return ResponseEntity.ok(newObj);
    }

    @PutMapping()
    public ResponseEntity<Donatario> update(@Valid @RequestBody Donatario obj){
        Donatario newobj = donatarioService.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Donatario> delete(@PathVariable Long id){
        donatarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
