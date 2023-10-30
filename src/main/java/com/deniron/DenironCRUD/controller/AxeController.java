package com.deniron.DenironCRUD.controller;

import com.deniron.DenironCRUD.exception.ResourceNotFoundException;
import com.deniron.DenironCRUD.model.Axe;
import com.deniron.DenironCRUD.repository.AxeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/axes")
public class AxeController {

    @Autowired
    private AxeRepository axeRepository;

    @GetMapping
    public List<Axe> getAllAxes(){
        return axeRepository.findAll();
    }

    // build create axe REST API
    @PostMapping
    public Axe createAxe(@RequestBody Axe axe) {
        return axeRepository.save(axe);
    }

    // build get axe by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Axe> getAxeById(@PathVariable int id){
        Axe axe = axeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Axe not exist with id:" + id));
        return ResponseEntity.ok(axe);
    }

    // build update axe REST API
    @PutMapping("{id}")
    public ResponseEntity<Axe> updateAxe(@PathVariable int id,@RequestBody Axe axeDetails) {
        Axe updateAxe = axeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Axe not exist with id: " + id));

        updateAxe.setAttack(axeDetails.getAttack());
        updateAxe.setDefense(axeDetails.getDefense());
        updateAxe.setHitPoints(axeDetails.getHitPoints());


        axeRepository.save(updateAxe);

        return ResponseEntity.ok(updateAxe);
    }

    // build delete axe REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteAxe(@PathVariable int id){

        Axe axe = axeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Axe not exist with id: " + id));

        axeRepository.delete(axe);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
