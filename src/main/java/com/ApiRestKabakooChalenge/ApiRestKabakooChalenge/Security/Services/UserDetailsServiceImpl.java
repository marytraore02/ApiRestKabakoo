package com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Security.Services;

import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Models.User;
import com.ApiRestKabakooChalenge.ApiRestKabakooChalenge.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

    // Cette méthode est utilisée par JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long userId){
        User user = this.userRepository.findById(userId).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + userId)
        );
        return UserDetailsImpl.build(user);
    }

}
