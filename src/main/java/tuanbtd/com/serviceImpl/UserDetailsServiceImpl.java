package tuanbtd.com.serviceImpl;
 
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tuanbtd.com.entity.Role;
import tuanbtd.com.entity.ThanhVien;
import tuanbtd.com.service.ThanhVienService;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ThanhVienService thanhVienService;
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ThanhVien tv = thanhVienService.getThanhVienByUsername(username);
 
        if (tv == null) {
            throw new UsernameNotFoundException("User " //
                    + username + " was not found in the database");
        }
 
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = tv.getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
 
        boolean enabled = tv.isEnabled();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
 
        UserDetails userDetails = (UserDetails) new User(tv.getUsername(), //
                tv.getPassword(), enabled, accountNonExpired, //
                credentialsNonExpired, accountNonLocked, grantedAuthorities);
 
        return userDetails;
    }
 
}