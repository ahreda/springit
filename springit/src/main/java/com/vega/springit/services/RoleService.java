package com.vega.springit.services;

import com.vega.springit.domain.Role;
import com.vega.springit.repository.RoleRepository;
import org.springframework.stereotype.Service;


@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }


}
