package com.deniron.DenironCRUD.controller;

import com.deniron.DenironCRUD.exception.ResourceNotFoundException;
import com.deniron.DenironCRUD.model.City;
import com.deniron.DenironCRUD.model.City;
import com.deniron.DenironCRUD.repository.CityRepository;
import com.deniron.DenironCRUD.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public List<City> getAllCitys(){
        return cityRepository.findAll();
    }

    // build create city REST API
    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityRepository.save(city);
    }

    // build get city by id REST API
    @GetMapping("{id}")
    public ResponseEntity<City> getCityById(@PathVariable  long id){
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not exist with id:" + id));
        return ResponseEntity.ok(city);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<City> getCityById(@PathVariable  String username){
        City city = cityService.findByUser(username);
        return ResponseEntity.ok(city);
    }

    // build update city REST API
    @PutMapping("{id}")
    public ResponseEntity<City> updateCity(@PathVariable long id,@RequestBody City cityDetails) {
        City updateCity = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not exist with id: " + id));

        updateCity.setCityName(cityDetails.getCityName());
        updateCity.setWood(cityDetails.getWood());
        updateCity.setStone(cityDetails.getStone());
        updateCity.setMud(cityDetails.getMud());


        cityRepository.save(updateCity);

        return ResponseEntity.ok(updateCity);
    }

    // build delete city REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCity(@PathVariable long id){

        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not exist with id: " + id));

        cityRepository.delete(city);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
