package com.deniron.DenironCRUD.controller;

import com.deniron.DenironCRUD.exception.ResourceNotFoundException;
import com.deniron.DenironCRUD.model.Sword;
import com.deniron.DenironCRUD.repository.SwordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/swords")
public class SwordController {

    @Autowired
    private SwordRepository swordRepository;

    @GetMapping
    public List<Sword> getAllSwords(){
        return swordRepository.findAll();
    }

    // build create sword REST API
    @PostMapping
    public Sword createSword(@RequestBody Sword sword) {
        return swordRepository.save(sword);
    }

    // build get sword by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Sword> getSwordById(@PathVariable int id){
        Sword sword = swordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sword not exist with id:" + id));
        return ResponseEntity.ok(sword);
    }

    // build update sword REST API
    @PutMapping("{id}")
    public ResponseEntity<Sword> updateSword(@PathVariable int id,@RequestBody Sword swordDetails) {
        Sword updateSword = swordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sword not exist with id: " + id));

        updateSword.setAttack(swordDetails.getAttack());
        updateSword.setDefense(swordDetails.getDefense());
        updateSword.setHitPoints(swordDetails.getHitPoints());


        swordRepository.save(updateSword);

        return ResponseEntity.ok(updateSword);
    }

    // build delete sword REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteSword(@PathVariable int id){

        Sword sword = swordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sword not exist with id: " + id));

        swordRepository.delete(sword);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
