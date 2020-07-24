package tuanbtd.com.config;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import tuanbtd.com.entity.Role;
import tuanbtd.com.entity.ThanhVien;
import tuanbtd.com.repository.ThanhVienRepository;
import tuanbtd.com.service.RoleService;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ThanhVienRepository thanhVienRepository;

    @Autowired
    private RoleService roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        // Roles
        if (roleRepository.getRoleByRoleName("ROLE_ADMIN") == null) {
            roleRepository.saveRole(new Role("ROLE_ADMIN"));
        }

        if (roleRepository.getRoleByRoleName("ROLE_MEMBER") == null) {
            roleRepository.saveRole(new Role("ROLE_MEMBER"));
        }

        // Admin account
        if (thanhVienRepository.getThanhVienByUsername("admin") == null) {
            ThanhVien admin = new ThanhVien("admin", "123456", true, null, "admin@gmail.com", "ADMIN", null, null);
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.getRoleByRoleName("ROLE_ADMIN"));
            roles.add(roleRepository.getRoleByRoleName("ROLE_MEMBER"));
            admin.setRoles(roles);
            thanhVienRepository.registerThanhVien(admin);
        }

        // Member account
        if (thanhVienRepository.getThanhVienByUsername("member") == null) {
            ThanhVien user = new ThanhVien("member", "123456", true, null, "member@gmail.com", "MEMBER", null, null);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.getRoleByRoleName("ROLE_MEMBER"));
            user.setRoles(roles);
            thanhVienRepository.registerThanhVien(user);
        }
    }

}