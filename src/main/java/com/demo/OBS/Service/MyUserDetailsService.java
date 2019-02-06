package com.demo.OBS.Service;

import com.demo.OBS.Dao.DaoUsers;
import com.demo.OBS.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private DaoUsers daoUsers;

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
        Users user = daoUsers.findUsersByUsername(username);
        MyUserDetails myUserDetails = new MyUserDetails(user);
        return myUserDetails;
    }


}
