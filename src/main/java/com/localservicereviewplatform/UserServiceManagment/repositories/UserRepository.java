package com.localservicereviewplatform.UserServiceManagment.repositories;

import com.localservicereviewplatform.UserServiceManagment.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {



    Optional<User> findByEmail(String email);
}
