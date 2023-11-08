package com.localservicereviewplatform.UserServiceManagment.controllers;

import com.localservicereviewplatform.UserServiceManagment.dtos.RoleDto;
import com.localservicereviewplatform.UserServiceManagment.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviewsystem")
public class RoleController {


    private final RolesService rolesService;



    public RoleController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @PostMapping("/create-role")
    public ResponseEntity<Void> createRole(@RequestBody RoleDto roleDto){
        return rolesService.createRoles(roleDto);
    }

    @DeleteMapping("/delete-role")
    public ResponseEntity<String> deleteRole(@RequestBody RoleDto roleDto){
        return rolesService.deleteRole(roleDto);
    }

}
