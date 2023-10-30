package com.deniron.DenironCRUD.repository;

import com.deniron.DenironCRUD.model.City;
import com.deniron.DenironCRUD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository  extends JpaRepository<City, Long> {

    @Query("SELECT c FROM City c WHERE c.user.username = :username")
    City findByUser(String username);
}
