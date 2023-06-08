package com.deniron.DenironCRUD.repository;

import com.deniron.DenironCRUD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    //crud methods
}
