package com.deniron.DenironCRUD.controller;

import com.deniron.DenironCRUD.exception.ResourceNotFoundException;
import com.deniron.DenironCRUD.model.Lance;
import com.deniron.DenironCRUD.repository.LanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/lances")
public class LanceController {

    @Autowired
    private LanceRepository lanceRepository;

    @GetMapping
    public List<Lance> getAllLances(){
        return lanceRepository.findAll();
    }

    // build create lance REST API
    @PostMapping
    public Lance createLance(@RequestBody Lance lance) {
        return lanceRepository.save(lance);
    }

    // build get lance by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Lance> getLanceById(@PathVariable int id){
        Lance lance = lanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lance not exist with id:" + id));
        return ResponseEntity.ok(lance);
    }

    // build update lance REST API
    @PutMapping("{id}")
    public ResponseEntity<Lance> updateLance(@PathVariable int id,@RequestBody Lance lanceDetails) {
        Lance updateLance = lanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lance not exist with id: " + id));

        updateLance.setAttack(lanceDetails.getAttack());
        updateLance.setDefense(lanceDetails.getDefense());
        updateLance.setHitPoints(lanceDetails.getHitPoints());


        lanceRepository.save(updateLance);

        return ResponseEntity.ok(updateLance);
    }

    // build delete lance REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteLance(@PathVariable int id){

        Lance lance = lanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lance not exist with id: " + id));

        lanceRepository.delete(lance);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
