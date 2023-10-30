package com.deniron.DenironCRUD.controller;

import com.deniron.DenironCRUD.exception.ResourceNotFoundException;
import com.deniron.DenironCRUD.model.Castle;
import com.deniron.DenironCRUD.repository.CastleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/castle")
public class CastleController {

    @Autowired
    private CastleRepository castleRepository;

    @GetMapping
    public List<Castle> getAllCastles(){
        return castleRepository.findAll();
    }

    // build get castle by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Castle> getCastleById(@PathVariable int id){
        Castle castle = castleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Castle not exist with id:" + id));
        return ResponseEntity.ok(castle);
    }


}
