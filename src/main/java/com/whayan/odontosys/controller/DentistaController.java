package com.whayan.odontosys.controller;

import com.whayan.odontosys.model.Dentista;
import com.whayan.odontosys.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/dentistas")
public class DentistaController {

    @Autowired
    private DentistaRepository dentistaRepository;

    @GetMapping
    public List<Dentista> listarTodos() {
        return dentistaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dentista cadastrar(@RequestBody Dentista dentista) {
        return dentistaRepository.save(dentista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentista> buscarPorId(@PathVariable Long id) {
        return dentistaRepository.findById(id)
                .map(dentista -> ResponseEntity.ok().body(dentista))
                .orElse(ResponseEntity.notFound().build());
    }
}