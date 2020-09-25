package at.savovuksan.VSMServer.Endpoints;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.savovuksan.VSMServer.Models.User;
import at.savovuksan.VSMServer.Repositories.UserRepository;

@RestController
@RequestMapping("/auth")
public class Authentication {
    
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/login")
    public User login(@RequestBody User user){
        return user;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user){
        Optional<User> opt = userRepo.findByEmail(user.getEmail());
        User u = null;
        if(opt.isEmpty()){
            u = userRepo.save(new User(user.getUsername(), encoder.encode(user.getPassword()), user.getEmail()));
        }
        return u;
        
    }

}
