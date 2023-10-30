package com.deniron.DenironCRUD.tasks;

import com.deniron.DenironCRUD.model.City;
import com.deniron.DenironCRUD.repository.CityRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResourceGenerationTask {

    private final CityRepository cityRepository;

    public ResourceGenerationTask(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Scheduled(fixedDelay = 60000) // Ejecutar cada 60 segundos
    public void generateResources() {
        List<City> cities = cityRepository.findAll();

        for (City city : cities) {
            // Incrementar los recursos en función de la lógica de generación
            int wood = city.getWood();
            int mud = city.getMud();
            int stone = city.getStone();

            // Lógica de generación de recursos
            // Aquí puedes implementar tu propia lógica para la generación de recursos
            wood+=city.getWoodcutter().getWoodProduction()/60;
            mud+=city.getPottery().getMudProduction()/60;
            stone+=city.getMine().getStoneProduction()/60;

            // Actualizar los valores en la entidad y guardarlos en la base de datos
            city.setWood(wood);
            city.setMud(mud);
            city.setStone(stone);
            cityRepository.save(city);
        }
    }

}
