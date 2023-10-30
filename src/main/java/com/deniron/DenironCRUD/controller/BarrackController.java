package com.deniron.DenironCRUD.controller;

import com.deniron.DenironCRUD.exception.ResourceNotFoundException;
import com.deniron.DenironCRUD.model.Barrack;
import com.deniron.DenironCRUD.repository.BarrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/barrack")
public class BarrackController {

    @Autowired
    private BarrackRepository barrackRepository;

    @GetMapping
    public List<Barrack> getAllBarracks(){
        return barrackRepository.findAll();
    }

    // build get barrack by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Barrack> getBarrackById(@PathVariable int id){
        Barrack barrack = barrackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barrack not exist with id:" + id));
        return ResponseEntity.ok(barrack);
    }


}
