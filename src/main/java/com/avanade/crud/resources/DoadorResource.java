package com.avanade.crud.resources;

import com.avanade.crud.domain.Doador;
import com.avanade.crud.services.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
