package com.localservicereviewplatform.UserServiceManagment.repositories;

import com.localservicereviewplatform.UserServiceManagment.models.Role;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Optional;
import java.util.function.Function;

public interface RoleRepository extends JpaRepository<Role, Long> {




    Optional<Role> findByRole(String roleName);
}
