package com.deniron.DenironCRUD.services;

import com.deniron.DenironCRUD.model.City;
import com.deniron.DenironCRUD.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City findByUser(String username) {
        return cityRepository.findByUser(username);
    }

}
