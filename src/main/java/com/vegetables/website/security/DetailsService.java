package com.vegetables.website.security;

import com.vegetables.website.dao.ApplicationUserDAO;
import com.vegetables.website.model.ApplicationUser;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailsService implements UserDetailsService {

    @Autowired
    private ApplicationUserDAO applicationUserDAO;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ApplicationUser user = applicationUserDAO.findByEmail(email);
        return new User(email, "{bcrypt}" + user.getPassword(), new ArrayList<>());
    }

}
