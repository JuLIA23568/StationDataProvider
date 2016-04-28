package by.bsuir.station.service.impl;

import by.bsuir.station.entity.SecurityUser;
import by.bsuir.station.entity.User;
import by.bsuir.station.service.SecurityService;
import by.bsuir.station.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.select(login);
        if(user == null){
            throw new UsernameNotFoundException("UserName "+login+" not found");
        }
        return new SecurityUser(user);
    }
}
