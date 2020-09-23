package at.savovuksan.VSMServer.Security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import at.savovuksan.VSMServer.Models.User;
import at.savovuksan.VSMServer.Repositories.UserRepository;

@Service
public class EmailUDS implements UserDetailsService {

    private final UserRepository userRepo;

    EmailUDS(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<User> opt = userRepo.findByEmail(username);

       opt.orElseThrow(() -> new UsernameNotFoundException("No user with email: " + username));

       User u = opt.get();
       return org.springframework.security.core.userdetails.User.builder()
       .username(u.getEmail())
       .password(u.getPassword())
       .roles("USER")
       .build();
    }


    
}
