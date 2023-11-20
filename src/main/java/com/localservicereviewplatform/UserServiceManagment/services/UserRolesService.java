package com.localservicereviewplatform.UserServiceManagment.services;

import com.localservicereviewplatform.UserServiceManagment.dtos.RoleDto;
import com.localservicereviewplatform.UserServiceManagment.dtos.UserDto;
import com.localservicereviewplatform.UserServiceManagment.models.Role;
import com.localservicereviewplatform.UserServiceManagment.repositories.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRolesService  implements  RolesService{


    private  final RoleRepository roleRepository;

    public UserRolesService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public ResponseEntity<Void> createRoles(RoleDto roleDto) {
      Role role = new Role();
      role.setRole(roleDto.getRolename());
      Role savedRole = roleRepository.save(role);
      if (savedRole!=null)
        return new ResponseEntity<>(HttpStatus.OK);

      throw new RuntimeException("Unable to save role in DB");
    }

    @Override
    public ResponseEntity<String> deleteRole(RoleDto roleDto) {
        Optional<Role> optionalRole = roleRepository.findByRole(roleDto.getRolename());
        if (optionalRole.isEmpty())
            return new ResponseEntity<>("Given role does not exist" , HttpStatus.NO_CONTENT);

        roleRepository.delete(optionalRole.get());
        return new ResponseEntity<>("Role Deleted successfully" , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> assignRoles() {
        return null;
    }

    @Override
    public ResponseEntity<List<Role>> fetchUserRoles() {
        return null;
    }
}
