package com.localservicereviewplatform.UserServiceManagment.services;

import com.localservicereviewplatform.UserServiceManagment.dtos.RoleDto;
import com.localservicereviewplatform.UserServiceManagment.dtos.UserDto;
import com.localservicereviewplatform.UserServiceManagment.models.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RolesService {

    public ResponseEntity<Void> createRoles(RoleDto roleDto);

    public ResponseEntity<String>deleteRole(RoleDto roleDto);

    public ResponseEntity<UserDto> assignRoles();

    public ResponseEntity<List<Role>> fetchUserRoles();
}
