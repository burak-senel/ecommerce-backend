package ecommerce.service;

import ecommerce.entity.Role;
import ecommerce.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements RoleService{
    private RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public List<Role>getRoles(){
    return roleRepository.findAll();
    }
}
