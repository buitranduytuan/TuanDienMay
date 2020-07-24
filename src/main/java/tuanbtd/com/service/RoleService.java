package tuanbtd.com.service;

import tuanbtd.com.entity.Role;

public interface RoleService {

    Role getRoleByRoleName(String roleName);

    void saveRole(Role role);

}