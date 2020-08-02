package com.mitocode.controller;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Paciente;
import com.mitocode.model.Signo;
import com.mitocode.service.ISignoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/signos")
public class SignoController {

    @Autowired
    private ISignoService service;

    @GetMapping
    public ResponseEntity<List<Signo>> listar() throws Exception{
        List<Signo> lista = service.listar();
        return new ResponseEntity<List<Signo>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Signo> listarPorId(@PathVariable("id") Integer id) throws Exception{
        Signo obj = service.listarPorId(id);
        if(obj == null ) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        return new ResponseEntity<Signo>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody Signo signo) throws Exception{
        Signo obj = service.registrar(signo);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdSigno()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Signo> modificar(@Valid @RequestBody Signo signo) throws Exception{
        Signo obj = service.modificar(signo);
        return new ResponseEntity<Signo>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
        Signo obj = service.listarPorId(id);
        if(obj.getIdSigno() == null ) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<Signo>> listarPageable(Pageable pageable) throws Exception{
        Page<Signo> signos = service.listarPageable(pageable);
        return new ResponseEntity<Page<Signo>>(signos, HttpStatus.OK);
    }

}
