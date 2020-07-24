package tuanbtd.com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuanbtd.com.entity.Role;
import tuanbtd.com.repository.RoleRepository;
import tuanbtd.com.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;
    
    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleRepository.getRoleByRoleName(roleName);
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.saveRole(role);
    }

}
