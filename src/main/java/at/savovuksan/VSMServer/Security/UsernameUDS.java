package at.savovuksan.VSMServer.Security;

import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import at.savovuksan.VSMServer.Repositories.UserRepository;

@Service
public class UsernameUDS implements UserDetailsService {

    private final UserRepository userRepo;

    public UsernameUDS(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<at.savovuksan.VSMServer.Models.User> opt = userRepo.findByUsername(username);

       opt.orElseThrow(() -> new UsernameNotFoundException("No user with username: "+ username));
        at.savovuksan.VSMServer.Models.User u = opt.get();
       return org.springframework.security.core.userdetails.User.builder()
       .username(u.getUsername())
       .password(u.getPassword())
       .roles("USER")
       .build();
    }
    
}
