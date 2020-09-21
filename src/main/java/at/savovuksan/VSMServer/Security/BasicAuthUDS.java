package at.savovuksan.VSMServer.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import at.savovuksan.VSMServer.Models.User;
import at.savovuksan.VSMServer.Repositories.UserRepository;

@Service
public class BasicAuthUDS implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Couldn't find: " + username));
        User u = user.get();

        return org.springframework.security.core.userdetails.User.builder()
        .username(u.getUsername())
        .password(u.getPassword())
        .roles("USER")
        .build();
    }
    
}
