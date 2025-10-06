package com.company.ems.config;

import com.company.ems.model.Role;
import com.company.ems.model.RoleName;
import com.company.ems.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

  @Autowired
  private RoleRepository roleRepository;

  @PostConstruct
  public void initRoles() {
    if(roleRepository.findByName(RoleName.ROLE_ADMIN).isEmpty()) {
      roleRepository.save(new Role(RoleName.ROLE_ADMIN));
    }
    if(roleRepository.findByName(RoleName.ROLE_USER).isEmpty()) {
      roleRepository.save(new Role(RoleName.ROLE_USER));
    }
  }
}
