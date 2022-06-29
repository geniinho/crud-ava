package com.avanade.crud.resources;

import com.avanade.crud.domain.Doador;
import com.avanade.crud.domain.dtos.DoadorDTO;
import com.avanade.crud.services.DoadorService;
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
@RequestMapping(value = "/doadores")
@Api(value = "API REST Doadores")
@CrossOrigin(origins = "*")
public class DoadorResource {

    @Autowired
    private DoadorService doadorService;

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Retorna um doador unico usando ID")
    public ResponseEntity<DoadorDTO> findById(@PathVariable Integer id){
        Doador obj = doadorService.findById(id);
        return ResponseEntity.ok().body(new DoadorDTO(obj));
    }

    @GetMapping
    @ApiOperation(value="Retorna uma lista de doadores")
    public ResponseEntity<List<DoadorDTO>> findAll(){
        List<Doador> list = doadorService.findAll();
        List<DoadorDTO> listDTO = list.stream().map(obj -> new DoadorDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    @ApiOperation(value="Cadastra um doador")
    public ResponseEntity<DoadorDTO> create(@Valid @RequestBody DoadorDTO objDTO){
        Doador newObj = doadorService.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value="Atualiza um doador")
    public ResponseEntity<DoadorDTO> update(@PathVariable Integer id, @Valid @RequestBody DoadorDTO objDTO){
        Doador obj = doadorService.update(id, objDTO);
        return ResponseEntity.ok().body(new DoadorDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value="Deleta um doador, caso já tenha feito uma doação sera lançada uma exceção")
    public ResponseEntity<DoadorDTO> delete(@PathVariable Integer id){
        doadorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
