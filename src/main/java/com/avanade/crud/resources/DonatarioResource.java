package com.avanade.crud.resources;

import com.avanade.crud.domain.Donatario;
import com.avanade.crud.domain.dtos.DonatarioDTO;
import com.avanade.crud.services.DonatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/donatarios")
public class DonatarioResource {
    @Autowired
    private DonatarioService donatarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DonatarioDTO> findById(@PathVariable Integer id){
        Donatario obj = donatarioService.findById(id);
        return ResponseEntity.ok().body(new DonatarioDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<DonatarioDTO>> findAll(){
        List<Donatario> list = donatarioService.findAll();
        List<DonatarioDTO> listDTO = list.stream().map(obj -> new DonatarioDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<DonatarioDTO> create(@Valid @RequestBody DonatarioDTO objDTO){
        Donatario newObj = donatarioService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DonatarioDTO> update(@PathVariable Integer id, @Valid @RequestBody DonatarioDTO objDTO){
        Donatario obj = donatarioService.update(id, objDTO);
        return ResponseEntity.ok().body(new DonatarioDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DonatarioDTO> delete(@PathVariable Integer id){
        donatarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
