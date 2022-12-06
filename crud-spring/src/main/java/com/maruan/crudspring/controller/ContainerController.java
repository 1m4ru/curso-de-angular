package com.maruan.crudspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maruan.crudspring.controller.model.Conteiner;
import com.maruan.crudspring.repository.ConteinerRepository;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/containers")
@AllArgsConstructor
public class ContainerController {

    private ConteinerRepository conteinerRepository;

    @GetMapping
    public List<Conteiner> List() {
        return conteinerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conteiner> findBy(@PathVariable Long id) {
        return conteinerRepository.findById(id).map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Conteiner create(@RequestBody Conteiner conteiner) {
        return conteinerRepository.save(conteiner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conteiner> update(@PathVariable Long id,
            @RequestBody Conteiner conteiner) {
        return conteinerRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setClient(conteiner.getClient());
                    recordFound.setNumberOfConteiner(conteiner.getNumberOfConteiner());
                    recordFound.setType(conteiner.getType());
                    recordFound.setStatus(conteiner.getStatus());
                    recordFound.setCategory(conteiner.getCategory());
                    Conteiner updated = conteinerRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return conteinerRepository.findById(id)
                .map(recordFound -> {
                    conteinerRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
