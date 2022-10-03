package com.carros.projectsptechac2.controller;


import com.carros.projectsptechac2.dominio.Carro;
import com.carros.projectsptechac2.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    @Autowired  //cria implementação para o h2 por exemplo
    private CarroRepository repository;

    @PostMapping
    public ResponseEntity<Carro> post(
            @RequestBody Carro novoCarro) {
        repository.save( novoCarro);
        return ResponseEntity.status(201).body(novoCarro);
    }

    @GetMapping
    public ResponseEntity<List<Carro>> get() {
        List<Carro> lista = repository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Carro> get(
            @PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }


}
