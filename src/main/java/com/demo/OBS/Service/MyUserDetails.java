package com.demo.OBS.Service;

import com.demo.OBS.Dao.DaoUsers;
import com.demo.OBS.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyUserDetails implements UserDetails {

    @Autowired
    private DaoUsers daoUsers;

    private Users user;

    public MyUserDetails(Users user){
        this.user=user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> list = new HashSet<GrantedAuthority>();
        String role = user.getRole();
        if (role.contains("ADMIN")){
            list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        else{
            if(role.contains("USER")){
                list.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
        }

        return list;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
